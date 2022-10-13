package org.bank.entity;

import java.util.Random;


public class Bank {
    private Integer id;
    private String name;
    private Integer countOffice;
    private Integer countAtm;
    private Integer countEmployee;
    private Integer countClient;
    private Integer rating;
    private Double money;
    private Double interestRate;

    public Bank() {
        id = -1;
        name = "";
        countOffice = 0;
        countAtm = 0;
        countEmployee = 0;
        countClient = 0;

        Random random = new Random();
        rating = random.nextInt(100);
        money = random.nextDouble(1000000);
        interestRate = 0.0;
    }

    public Bank(Integer _id, String _name) {
        id = _id;
        name = _name;
        countOffice = 0;
        countAtm = 0;
        countEmployee = 0;
        countClient = 0;

        Random random = new Random();
        rating = random.nextInt(100);
        money = random.nextDouble(1000000);
        interestRate = 0.0;
    }

    @Override
    public String toString() {
        return "ID банка: " + id + "\n" +
                "Банк: " + name + " \n" +
                "Количество офисов: " + countOffice + "\n" +
                "Количество банкоматов: " + countAtm + "\n" +
                "Количество работников: " + countEmployee + "\n" +
                "Количество клиентов: " + countClient + "\n" +
                "Рейтинг: " + rating + "\n" +
                "Количество денег: " + String.format("%.4f", money) + "\n" +
                "Процентная ставка: " + String.format("%.2f", interestRate) + "\n";
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

    public void setCountOffice(Integer count) {
        if (count >= 0) {
            countOffice = count;
        } else {
            System.out.println("Ошибка! Кол-во офисов не может быть отрицательным числом!");
        }
    }

    public Integer getCountOffice() {
        return countOffice;
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

    public void setCountEmployee(Integer count) {
        if (count >= 0) {
            countEmployee = count;
        } else {
            System.out.println("Ошибка! Кол-во работников не может быть отрицательным числом!");
        }
    }

    public Integer getCountEmployee() {
        return countEmployee;
    }

    public void setCountClient(Integer count) {
        if (count >= 0) {
            countClient = count;
        } else {
            System.out.println("Ошибка! Кол-во клиентов не может быть отрицательным числом!");
        }
    }

    public Integer getCountClient() {
        return countClient;
    }

    public void setRating(Integer _rating) {
        if ((_rating >= 0) && (_rating <= 100) ) {
            rating = _rating;
        } else {
            System.out.println("Ошибка! Рейтинг должен быть в диапозоне [0; 100]");
        }
    }

    public Integer getRating() {
        return rating;
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

    public void setInterestRate(Double rate) {
        if ((rate >= 2) && (rate <=20)) {
            interestRate = rate;
        } else {
            System.out.println("Ошибка! Процентная ставка должна быть в диапозоне [2; 20]");
        }
    }
    public Double getInterestRate() {
        return interestRate;
    }
}
