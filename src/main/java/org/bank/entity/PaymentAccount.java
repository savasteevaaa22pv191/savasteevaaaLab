package org.bank.entity;

public class PaymentAccount extends Account {
    private Double money;

    public PaymentAccount() {
        super();
        money = 0.0;
    }

    public PaymentAccount(Integer _id, User _user) {
        super(_id, _user);
        bank = null;
        money = 0.0;
    }

    @Override
    public String toString() {
        return "ID платежного аккаунта: " + id + "\n" +
                "Банк: " + (bank != null ? bank.getName() : "") + " \n" +
                "Владелец: " + (user != null ? user.getName() : "") + "\n" +
                "Количество денег: " + String.format("%.4f", money) + "\n";
    }

    public void setMoney(Double _money) {
        if (_money >= 0) {
            money = _money;
        } else {
            System.out.println("Ошибка! Кол-во денег не может быть отрицательным числом!");
        }
    }

    public Double getMoney() {
        return money;
    }
}
