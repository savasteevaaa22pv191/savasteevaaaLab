package org.bank.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Human {
    protected Integer id;
    protected String name;
    protected Calendar dateBirth;

    public Human() {
        id = -1;
        name = "";
        dateBirth = new GregorianCalendar();
    }

    public Human(Integer _id, String _name, Calendar _dateBirth) {
        id = _id;
        name = _name;
        dateBirth = _dateBirth;
    }

    public void setId(Integer _id) {
        if (_id >= 0) {
            id = _id;
        } else {
            System.out.println("Ошибка! ID не может быть отрицательным числом!");
        }
    }

    public Integer getId() {
        return id;
    }

    public void setName(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }

    public void setDateBirth(Calendar date) {
        dateBirth = date;
    }

    public Calendar getDateBirth() {
        return dateBirth;
    }
}
