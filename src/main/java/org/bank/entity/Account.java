package org.bank.entity;

public class Account {
    protected Integer id;
    protected User user;
    protected Bank bank;

    public Account() {
        id = -1;
        user = null;
        bank = null;
    }

    public Account(Integer _id, User _user) {
        id = _id;
        user = _user;
        bank = null;
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

    public void setUser(User _user) {
        user = _user;
    }

    public User getUser() {
        return user;
    }

    public void setBank(Bank _bank) {
        bank = _bank;
    }

    public Bank getBank() {
        return bank;
    }
}
