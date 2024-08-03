package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class CompanySection extends AbstractSection<List<Company>, Company> {

    private final List<Company> companies;

    public CompanySection(List<Company> companies) {
        this.companies = companies;
    }

    public CompanySection() {
        this.companies = new ArrayList<>();
    }

    public void add(Company entity) {
        companies.add(entity);
    }

    // @Override
    public List<Company> get() {
        return companies;
    }
}
