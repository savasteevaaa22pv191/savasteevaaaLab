package org.bank.entity;

public class PaymentAccount extends Account {
    private double money;

    public PaymentAccount() {
        super();
        money = 0.0;
    }

    public PaymentAccount(int id, User user, Bank bank, double money) {
        super(id, user, bank);
        this.money = money;
    }

    public PaymentAccount(PaymentAccount paymentAccount) {
        super(paymentAccount.getId(), paymentAccount.getUser(), paymentAccount.getBank());
        this.money = paymentAccount.getMoney();
    }

    @Override
    public String toString() {
        return "ID платежного аккаунта: " + id + "\n" +
                "Банк: " + (bank != null ? bank.getName() : "") + " \n" +
                "Владелец: " + (user != null ? user.getName() : "") + "\n" +
                "Количество денег: " + String.format("%.4f", money) + "\n";
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
}
