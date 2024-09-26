package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection<List<String>, String> {
    private static final long serialVersionUID = 1L;
    private List<String> strings;

    public ListSection() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(strings, that.strings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strings);
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "strings=" + strings +
                '}';
    }
}
