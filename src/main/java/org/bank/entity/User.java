package org.bank.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class User extends Person {
    private String addressJob;
    private Double monthIncome;
    private Bank bank;
    private CreditAccount creditAccount;
    private PaymentAccount paymentAccount;
    private Integer creditRating;

    public User() {
        super();
        addressJob = "";
        monthIncome = 0.0;
        bank = null;
        creditAccount = null;
        paymentAccount = null;
        creditRating = 0;
    }

    public User(Integer _id, String _name, Calendar _dateBirth) {
        super(_id, _name, _dateBirth);
        addressJob = "";
        monthIncome = 0.0;
        bank = null;
        creditAccount = null;
        paymentAccount = null;
        creditRating = 0;
    }

    @Override
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MMM.yyyy");

        return "ID пользователя: " + id + "\n" +
                "Имя пользователя: " + name + " \n" +
                "Дата рождения: " + fmt.format(dateBirth.getTime()) + "\n" +
                "Работа: " + addressJob + "\n" +
                "Ежемесячный доход: " + String.format("%.4f", monthIncome) + "\n" +
                "Банк: " + (bank != null ? bank.getName() : "") + "\n" +
                "ID кредитного аккаунта: " + (creditAccount != null ? creditAccount.getId() : "") + "\n" +
                "ID платежного аккаунта: " + (paymentAccount != null ? paymentAccount.getId() : "") + "\n" +
                "Кредитный рейтинг: " + creditRating + "\n";
    }

    public void setAddressJob(String address) {
        addressJob = address;
    }

    public String getAddressJob() {
        return addressJob;
    }

    public void setMonthIncome(Double _monthIncome) {
        if ((_monthIncome >= 0) && (_monthIncome <= 10000)) {
            monthIncome = _monthIncome;
        } else {
            System.out.println("Ошибка! Ежемесячный дохож не может быть отрицательным числом и не может превышать 10000!");
        }
    }

    public Double getMonthIncome() {
        return monthIncome;
    }

    public void setBank(Bank _bank) {
        bank = _bank;
    }

    public Bank getBank() {
        return bank;
    }

    public void setCreditAccount(CreditAccount account) {
        creditAccount = account;
    }

    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    public void setPaymentAccount(PaymentAccount account) {
        paymentAccount = account;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setCreditRating(Integer rating) {
        creditRating = rating;
    }

    public Integer getCreditRating() {
        return creditRating;
    }
}
