package org.bank.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Employee extends Person {
    private String jobTitle;
    private Bank bank;
    private Boolean remoteWork;
    private BankOffice office;
    private Boolean isGiveCredit;
    private Double salary;

    public Employee() {
        super();
        jobTitle = "";
        bank = null;
        remoteWork = false;
        office = null;
        isGiveCredit = false;
        salary = 0.0;
    }

    public Employee(Integer _id, String _name, Calendar _dateBirth) {
        super(_id, _name, _dateBirth);
        jobTitle = "";
        bank = null;
        remoteWork = false;
        office = null;
        isGiveCredit = false;
        salary = 0.0;
    }

    @Override
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MMM.yyyy");

        return "ID работника: " + id + "\n" +
                "Имя работаника: " + name + " \n" +
                "Дата рождения: " + fmt.format(dateBirth.getTime()) + "\n" +
                "Должность: " + jobTitle + "\n" +
                "Банк: " + (bank != null ? bank.getName() : "") + "\n" +
                "Офис: " + (office != null ? office.getName() : "") + "\n" +
                "Работает удаленно: " + (remoteWork ? "да" : "нет") + "\n" +
                "Выдает кредиты: " + (isGiveCredit ? "да" : "нет") + "\n" +
                "Зарплата: " + String.format("%.4f", salary) + "\n";
    }

    public void setJobTitle(String _jobTitle) {
        jobTitle = _jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setBank(Bank _bank) {
        bank = _bank;
    }

    public Bank getBank() {
        return bank;
    }

    public void setRemoteWork(Boolean _remoteWork) {
        remoteWork = _remoteWork;
    }

    public Boolean getRemoteWork() {
        return remoteWork;
    }

    public void setOffice(BankOffice _office) {
        office = _office;
    }

    public BankOffice getOffice() {
        return office;
    }

    public void setIsGiveCredit(Boolean _isGiveCredit) {
        isGiveCredit = _isGiveCredit;
    }

    public Boolean getIsGiveCredit() {
        return isGiveCredit;
    }

    public void setSalary(Double _salary) {
        if (_salary >= 0) {
            salary = _salary;
        } else {
            System.out.println("Ошибка! Зарплата не может быть отрицательным числом! Или может?");
        }
    }

    public Double getSalary() {
        return salary;
    }
}
