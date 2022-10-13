package org.bank.entity;

import org.bank.utils.Status;

public class BankAtm {
    private Integer id;
    private String name;
    private String address;
    private Status status;
    private Bank bank;
    private BankOffice bankOffice;
    private Employee employee;
    private Boolean isGiveMoney;
    private Boolean isPayInMoney;
    private Double money;
    private Double servicePrice;

    public BankAtm() {
        id = -1;
        name = "";
        address = "";
        status = Status.NOT_WORK;
        bank = null;
        bankOffice = null;
        employee = null;
        isGiveMoney = false;
        isPayInMoney = false;
        money = 0.0;
        servicePrice = 0.0;
    }

    public BankAtm(Integer _id, String _name, Status _status, Bank _bank, BankOffice _bankOffice, Employee _employee,
                   Boolean _isGiveMoney, Boolean _isPayInMoney) {
        id = _id;
        name = _name;
        address = _bankOffice.getAddress();
        status = _status;
        bank = _bank;
        bankOffice = _bankOffice;
        employee = _employee;
        isGiveMoney = _isGiveMoney;
        isPayInMoney = _isPayInMoney;
        money = 0.0;
        servicePrice = 0.0;
    }

    @Override
    public String toString() {
        return "ID банкомата: " + id + "\n" +
                "Банкомат: " + name + " \n" +
                "Адрес: " + address + "\n" +
                "Статус: " + status.getName() + "\n" +
                "Банк: " + (bank != null ? bank.getName() : "") + "\n" +
                "Офис: " + (bankOffice != null ? bankOffice.getName() : "") + "\n" +
                "Работник: " + (employee != null ? employee.getName() : "") + "\n" +
                "Выдает деньги: " + (isGiveMoney ? "да" : "нет") + "\n" +
                "Можно положить деньги: " + (isPayInMoney ? "да" : "нет") + "\n" +
                "Количество денег: " + String.format("%.4f", money) + "\n" +
                "Стоимость обслуживания: " + String.format("%.4f", servicePrice) + "\n";
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

    public void setAddress(String _address) {
        address = _address;
    }

    public String getAddress() {
        return address;
    }

    public void setStatus(Status _status) {
        status = _status;
    }

    public Status getStatus() {
        return status;
    }

    public void setBank(Bank _bank) {
        bank = _bank;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBankOffice(BankOffice _bankOffice) {
        bankOffice = _bankOffice;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setEmployee(Employee _employee) {
        employee = _employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setIsGiveMoney(Boolean _isGiveMoney) {
        isGiveMoney = _isGiveMoney;
    }

    public Boolean getIsGiveMoney() {
        return isGiveMoney;
    }

    public void setIsPayInMoney(Boolean _isPayInMoney) {
        isPayInMoney = _isPayInMoney;
    }

    public Boolean getIsPayInMoney() {
        return isPayInMoney;
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

    public void setServicePrice(Double money) {
        if (money >= 0) {
            servicePrice = money;
        } else {
            System.out.println("Ошибка! Стоимость обслуживания не может быть отрицательным числом!");
        }
    }

    public Double getServicePrice() {
        return servicePrice;
    }
}
