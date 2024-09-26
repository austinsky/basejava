package com.urise.webapp.storage.serializator;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements Serializator {

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            Map<ContactType, String> contacts = r.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            // TODO implements sections
            Map<SectionType, AbstractSection> sections = r.getSections();
            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                AbstractSection section = entry.getValue();
                String className = section.getClass().getSimpleName();
                dos.writeUTF(className);

                switch (className) {
                    case "CompanySection":
                        List<Company> companies = ((CompanySection)section).get();
                        dos.writeInt(companies.size());
                        for (Company company : companies) {
                            dos.writeUTF(company.getName());
                            dos.writeUTF(company.getWebsite());
                            List<Period> periods = company.getPeriods();
                            dos.writeInt(periods.size());
                            for (Period period : periods) {
                                dos.writeUTF(period.getTitle());
                                dos.writeUTF(period.getDescription());
                                LocalDate beginDate = period.getBeginDate();
                                LocalDate endDate = period.getEndDate();
                                dos.writeInt(beginDate.getYear());
                                dos.writeInt(beginDate.getMonth().getValue());
                                dos.writeInt(endDate.getYear());
                                dos.writeInt(endDate.getMonth().getValue());
                            }
                        }
                        break;
                    case "ListSection":
                        List<String> values = ((ListSection)section).get();
                        dos.writeInt(values.size());
                        for (String value : values) {
                            dos.writeUTF(value);
                        }
                        break;
                    case "TextSection":
                        dos.writeUTF(((TextSection)section).get());
                        break;
                }

            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                resume.setContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }
            // TODO implements sections
            int sizeSections = dis.readInt();
            for (int k = 0; k < sizeSections; k++) {
                String key = dis.readUTF();
                AbstractSection section = null;
                String className = dis.readUTF();

                switch (className) {
                    case "CompanySection":
                        List<Company> companies = new ArrayList<>();
                        int countCompanies =  dis.readInt();
                        for (int i = 0; i < countCompanies; i++) {
                            String name = dis.readUTF();
                            String website = dis.readUTF();
                            List<Period> periods = new ArrayList<>();
                            int countPeriods = dis.readInt();
                            for (int j = 0; j < countPeriods; j++) {
                                String title = dis.readUTF();
                                String description = dis.readUTF();
                                int beginYear = dis.readInt();
                                int beginMonth = dis.readInt();
                                int endYear = dis.readInt();
                                int endMonth = dis.readInt();
                                Period period = new Period(beginMonth, beginYear, endMonth, endYear, title, description);
                                periods.add(period);
                            }
                            companies.add(new Company(name, website, periods));
                        }
                        section = new CompanySection(companies);
                        break;
                    case "ListSection":
                        List<String> values = new ArrayList<>();
                        int countRecords = dis.readInt();
                        for (int i = 0; i < countRecords; i++) {
                            values.add(dis.readUTF());
                        }
                        section = new ListSection(values.toArray(new String[0]));
                        break;
                    case "TextSection":
                        section = new TextSection(dis.readUTF());
                        break;
                }

                resume.setSection(SectionType.valueOf(key), section);
            }
            return resume;
        }
    }
}
