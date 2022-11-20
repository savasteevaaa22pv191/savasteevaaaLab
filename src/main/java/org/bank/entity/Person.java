package org.bank.entity;

import java.time.LocalDate;

public class Person {
    protected int id;
    protected String name;
    protected LocalDate dateBirth;

    public Person() {
        id = -1;
        name = "";
        dateBirth = null;
    }

    public Person(int id, String name, LocalDate dateBirth) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDateBirth(LocalDate date) {
        dateBirth = date;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }
}
