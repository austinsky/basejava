package com.urise.webapp.model;

import java.util.Objects;

public class TextSection extends AbstractSection<String, Object> {
    private String text;

    public TextSection(String text) {
        this.text = text;
    }

    public String get() {
        return text;
    }

    // @Override
    public void add(Object newValue) {
        new IllegalArgumentException("Операция не поддерживается");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "text='" + text + '\'' +
                '}';
    }
}