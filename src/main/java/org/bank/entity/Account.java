package org.bank.entity;

public class Account {
    protected int id;
    protected User user;
    protected Bank bank;

    public Account() {
        id = -1;
        user = null;
        bank = null;
    }

    public Account(int id, User user, Bank bank) {
        this.id = id;
        this.user = user;
        this.bank = bank;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }
}
