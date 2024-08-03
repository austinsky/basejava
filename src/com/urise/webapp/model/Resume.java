package com.urise.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;
    private String fullName;

    private Map<ContactType, String> contacts = new HashMap<>();
    private Map<SectionType, AbstractSection> sections = new HashMap<>();

    public Resume(String fullName) {
        this.fullName = fullName;
        this.uuid = UUID.randomUUID().toString();
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setContact(ContactType contactType, String value) {
        contacts.put(contactType, value);
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public void setSection(SectionType sectionType, AbstractSection value) {
        sections.put(sectionType, value);
    }

    public Map<SectionType, AbstractSection> getSections() {
        return sections;
    }
//
//
    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Resume resume) {
        int result = fullName.compareTo(resume.getFullName());
        return (result == 0) ? uuid.compareTo(resume.getUuid()) : result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) && Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }
}
