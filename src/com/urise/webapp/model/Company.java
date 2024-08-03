package com.urise.webapp.model;

import java.util.List;

public class Company {
    private String name;
    private String website;

    private List<Period> periods;

    public Company(String name, String website, List<Period> periods) {
        this.name = name;
        this.website = website;
        this.periods = periods;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }
}
