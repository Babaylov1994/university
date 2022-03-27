package com.foxminded.university.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class Person {

    @Column(name = "first_name")
    protected String name;

    @Column(name = "last_name")
    protected String lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
