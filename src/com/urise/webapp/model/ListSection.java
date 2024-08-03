package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSection extends AbstractSection<List<String>, String> {
    List<String> strings = new ArrayList<>();

    public ListSection(String... strings) {
        this.strings = Arrays.stream(strings).toList();
    }

    public List<String> get() {
        return strings;
    }

    // @Override
    public void add(String value) {
        strings.add(value);
    }
}
