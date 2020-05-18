package com.course.servicemesh.authors.courseservicemeshauthors.models;

import java.util.Date;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Author(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Author withFirstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }

    public Author withLastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }

    public Author withBirthDate(Date date) {
        this.setBirthDate(date);
        return this;
    }
}
