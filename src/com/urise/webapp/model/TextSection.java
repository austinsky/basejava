package com.urise.webapp.model;

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
}
