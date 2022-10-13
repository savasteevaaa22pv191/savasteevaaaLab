package org.bank.entity;

public class BankOffice {
    private Integer id;
    private String name;
    private String address;
    private Bank bank;
    private Boolean isWorking;
    private Boolean isInstallAtm;
    private Integer countAtm;
    private Boolean isGiveCredit;
    private Boolean isGiveMoney;
    private Boolean isPayInMoney;
    private Double money;
    private Double rentPrice;

    public BankOffice() {
        id = -1;
        name = "";
        address = "";
        bank = null;
        isWorking = false;
        isInstallAtm = false;
        countAtm = 0;
        isGiveCredit = false;
        isGiveMoney = false;
        isPayInMoney = false;
        money = 0.0;
        rentPrice = 0.0;
    }

    public BankOffice(Integer _id, String _name, String _address, Bank _bank) {
        id = _id;
        name = _name;
        address = _address;
        bank = _bank;
        isWorking = false;
        isInstallAtm = false;
        countAtm = 0;
        isGiveCredit = false;
        isGiveMoney = false;
        isPayInMoney = false;
        money = 0.0;
        rentPrice = 0.0;
    }

    @Override
    public String toString() {
        return "ID офиса: " + id + "\n" +
                "Банковский офис " + name + "\n" +
                "Банк: " + (bank != null ? bank.getName() : "") + " \n" +
                "Адрес: " + address + "\n" +
                "Работает: " + (isWorking ? "да" : "нет") + "\n" +
                "Можно устанавливать банкоматы: " + (isInstallAtm ? "да" : "нет") + "\n" +
                "Кол-во банкоматов: " + countAtm + "\n" +
                "Выдает кредиты: " + (isGiveCredit ? "да" : "нет") + "\n" +
                "Выдает деньги: " + (isGiveMoney ? "да" : "нет") + "\n" +
                "Можно вносить деньги: " + (isPayInMoney ? "да" : "нет") + "\n" +
                "Кол-во денег: " + String.format("%.4f", money) + "\n" +
                "Стоимость аренды: " + String.format("%.4f", rentPrice) + "\n";
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

    public void setBank(Bank _bank) {
        bank = _bank;
    }

    public Bank getBank() {
        return bank;
    }

    public void setIsWorking(Boolean flag) {
        isWorking = flag;
    }

    public Boolean getIsWorking() {
        return isWorking;
    }

    public void setIsInstallAtm(Boolean flag) {
        isInstallAtm = flag;
    }

    public Boolean getIsInstallAtm() {
        return isInstallAtm;
    }

    public void setCountAtm(Integer count) {
        if (count >= 0) {
            countAtm = count;
        } else {
            System.out.println("Ошибка! Кол-во банкоматов не может быть отрицательным числом!");
        }
    }

    public Integer getCountAtm() {
        return countAtm;
    }

    public void setIsCredit(Boolean flag) {
        isGiveCredit = flag;
    }

    public Boolean getIsCredit() {
        return isGiveCredit;
    }

    public void setIsGiveMoney(Boolean flag) {
        isGiveMoney = flag;
    }

    public Boolean getIsGiveMoney() {
        return isGiveMoney;
    }

    public void setIsPayInMoney(Boolean flag) {
        isPayInMoney = flag;
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

    public void setRentPrice(Double money) {
        if (money >= 0) {
            rentPrice = money;
        } else {
            System.out.println("Ошибка! Стоимость аренды не может быть отрицательным числом!");
        }
    }

    public Double getRentPrice() {
        return rentPrice;
    }
}
