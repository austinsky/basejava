package com.urise.webapp.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Period implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String description;
    private LocalDate beginDate;
    private LocalDate endDate;


    public Period(String title, String description, LocalDate beginDate, LocalDate endDate) {
        this.title = title;
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Period(int beginMonth, int beginYear, int endMonth, int endYear, String title, String description) {
        if (beginMonth == 0) { beginMonth = 1; }
        if (endMonth == 0) { endMonth = 1;}

        LocalDate beginDate = LocalDate.of(beginYear, beginMonth, 1);
        LocalDate endDate = LocalDate.of(endYear, endMonth, 1);
        this.title = title;
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public int getBeginMonth() {
        return beginDate.getMonth().getValue();
    }

    public int getBeginYear() {
        return beginDate.getYear();
    }

    public int getEndMonth() {
        return endDate.getMonth().getValue();
    }

    public int getEndYear() {
        return endDate.getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return Objects.equals(title, period.title) && Objects.equals(description, period.description) && Objects.equals(beginDate, period.beginDate) && Objects.equals(endDate, period.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, beginDate, endDate);
    }

    @Override
    public String toString() {
        return "Period{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
