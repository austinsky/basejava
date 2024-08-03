package com.urise.webapp.model;

public enum ContactType {
    PHONE("Телефон"),

    EMAIL("Почта"),
    TELEGRAM("Телеграмм"),
    WHATSAPP("WhatsApp"),
    VIBER("Viber"),
    SKYPE("Skype"),
    GITHUB("Github"),
    LINKEDIN("Linkedin"),
    WEBSITE("Web Site"),

    STACKOVERFLOW("StackOverFlow");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
