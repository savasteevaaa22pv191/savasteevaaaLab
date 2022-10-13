package org.bank.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class CreditAccount extends Account {
    private Calendar dateStart;
    private Calendar dateEnd;
    private Integer countMonth;
    private Double money;
    private Double monthPay;
    private Double interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    private Double remainingSum;

    public CreditAccount() {
        super();
        dateStart = new GregorianCalendar();
        dateEnd = new GregorianCalendar();
        countMonth = 0;
        money = 0.0;
        monthPay = 0.0;
        interestRate = 0.0;
        employee = null;
        paymentAccount = null;
        remainingSum = money;
    }

    public CreditAccount(Integer _id, User _user, Calendar _dateStart, Integer _countMonth, Double _money,
                         PaymentAccount _paymentAccount) {
        super(_id, _user);

        dateStart = _dateStart;
        dateEnd = null;
        setCountMonth(_countMonth);
        setMoney(_money);
        monthPay = 0.0;
        employee = null;
        paymentAccount = _paymentAccount;
        interestRate = 0.0;
        remainingSum = money;
    }

    @Override
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MMM.yyyy");

        return "ID кредитного аккаунта: " + id + "\n" +
                "Банк: " + (bank != null ? bank.getName() : "") + " \n" +
                "Владелец: " + (user != null ? user.getName() : "") + "\n" +
                "Суммма кредита: " + String.format("%.4f", money) + "\n" +
                "Дата начала кредита: " + (dateStart != null ? fmt.format(dateStart.getTime()) : "") + "\n" +
                "Дата окончания кредита: " + (dateEnd != null ? fmt.format(dateEnd.getTime()): "") + "\n" +
                "Кол-во месяцев: " + countMonth + "\n" +
                "Ежемесячная выплата: " + String.format("%.4f", monthPay) + "\n" +
                "Процентная ставка: " + String.format("%.2f", interestRate) + "\n" +
                "Работник: " + (employee != null ? employee.getName() : "") + "\n" +
                "ID платежного аккаунта: " + (paymentAccount != null ? paymentAccount.getId() : "") + "\n";
    }

    public void setDateStart(Calendar date) {
        dateStart = date;
    }

    public Calendar getDateStart() {
        return dateStart;
    }

    public void setDateEnd(Calendar date) {
        dateEnd = date;
    }

    public Calendar getDateEnd() {
        return dateEnd;
    }

    public void setCountMonth(Integer count) {
        if (count >= 0) {
            countMonth = count;
        } else {
            System.out.println("Ошибка! Кол-во месяцев не может быть отрицательным числом!");
        }
    }

    public Integer getCountMonth() {
        return countMonth;
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

    public void setMonthPay(Double _monthPay) {
        monthPay = _monthPay;
    }

    public Double getMonthPay() {
        return monthPay;
    }

    public void setInterestRate(Double _interestRate) {
        if (_interestRate < 0) {
            System.out.println("Ошибка! Процентная ставка кредита не может быть отрицательным числом!");
        } else {
            if (bank != null) {
                if (_interestRate <= bank.getInterestRate()) {
                    interestRate = _interestRate;
                } else {
                    System.out.println("Ошибка! Процентная ставка кредита не может быть больше ставки банка!");
                }
            } else {
                System.out.println("Ошибка! Нельзя установить процентную ставку кредита без банка!");
            }
        }
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setEmployee(Employee _employee) {
        employee = _employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setPaymentAccount(PaymentAccount _paymentAccount) {
        paymentAccount = _paymentAccount;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setRemainingSum(Double sum) {
        remainingSum = sum;
    }

    public Double getRemainingSum() {
        return remainingSum;
    }
}
