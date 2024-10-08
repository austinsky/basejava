package com.urise.webapp.storage.serializator;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements Serializator {

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            Map<ContactType, String> contacts = r.getContacts();

            writeWithException(contacts.entrySet(), dos, entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });

            // implements sections
            Map<SectionType, AbstractSection> sections = r.getSections();

            writeWithException(sections.entrySet(), dos, entry -> {
                SectionType key = entry.getKey();
                dos.writeUTF(key.name());
                AbstractSection section = entry.getValue();

                switch (key) {
                    case OBJECTIVE:
                        dos.writeUTF(((TextSection) section).get());
                        break;

                    case PERSONAL:
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        List<String> values = ((ListSection) section).get();
                        writeWithException(values, dos, dos::writeUTF);
                        break;

                    case EXPERIENCE:
                    case EDUCATION:
                        List<Company> companies = ((CompanySection) section).get();
                        writeWithException(companies, dos, company -> {
                            dos.writeUTF(company.getName());
                            dos.writeUTF(company.getWebsite());
                            List<Period> periods = company.getPeriods();
                            writeWithException(periods, dos, period -> writePeriod(dos, period));
                        });
                        break;
                }
            });
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            readWithException(dis, () -> resume.setContact(ContactType.valueOf(dis.readUTF()), dis.readUTF()));
            // implements sections
            readWithException(dis, () -> {
                String key = dis.readUTF();
                AbstractSection section = null;

                switch (SectionType.valueOf(key)) {
                    case OBJECTIVE:
                        section = new TextSection(dis.readUTF());
                        break;
                    case PERSONAL:
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        List<String> values = new ArrayList<>();
                        readWithException(dis, () -> values.add(dis.readUTF()));
                        section = new ListSection(values);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        List<Company> companies = new ArrayList<>();
                        readWithException(dis, () -> {
                            String name = dis.readUTF();
                            String website = dis.readUTF();
                            List<Period> periods = new ArrayList<>();
                            readWithException(dis, () -> {
                                Period period = readPeriod(dis);
                                periods.add(period);
                            });
                            companies.add(new Company(name, website, periods));
                        });
                        section = new CompanySection(companies);
                        break;
                }

                resume.setSection(SectionType.valueOf(key), section);
            });
            return resume;
        }
    }

    private void writePeriod(DataOutputStream dos, Period period) throws IOException {
        dos.writeUTF(period.getTitle());
        dos.writeUTF(period.getDescription());
        writeDate(dos, period.getBeginDate());
        writeDate(dos, period.getEndDate());
    }

    private void writeDate(DataOutputStream dos, LocalDate date) throws IOException {
        dos.writeInt(date.getYear());
        dos.writeInt(date.getMonth().getValue());
    }


    private Period readPeriod(DataInputStream dis) throws IOException {
        String title = dis.readUTF();
        String description = dis.readUTF();
        LocalDate beginDate = readDate(dis);
        LocalDate endDate = readDate(dis);
        return new Period(title, description, beginDate, endDate);
    }

    private LocalDate readDate(DataInputStream dis) throws IOException {
        int year = dis.readInt();
        int month = dis.readInt();
        return LocalDate.of(year, month, 1);
    }

    private <T> void writeWithException(Collection<T> collection,
                                        DataOutputStream dos,
                                        MyWriter<T> consumer) throws IOException {
        dos.writeInt(collection.size());
        for (T t : collection) {
            consumer.execute(t);
        }
    }

    private void readWithException(DataInputStream dis,
                                   MyReader consumer) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; ++i) {
            consumer.execute();
        }
    }
}
