package org.bank.service.impl;

import org.bank.entity.Bank;
import org.bank.entity.CreditAccount;
import org.bank.entity.Employee;
import org.bank.entity.User;
import org.bank.service.BankService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class BankServiceImpl implements BankService {
    @Override
    public void calculateInterestRate(Bank bank) {
        if (bank != null) {
            Random random = new Random();
            Integer rating = bank.getRating();

            if (rating < 30) {
                bank.setInterestRate(random.nextDouble(20 - 16 + 1) + 16);             // [16; 20]
            } else if (rating < 60) {
                bank.setInterestRate(random.nextDouble(15 - 11 + 1) + 11);             // [11; 15]
            } else if (rating < 90) {
                bank.setInterestRate(random.nextDouble(10 - 6 + 1) + 6);               // [6; 10]
            } else {
                bank.setInterestRate(random.nextDouble(5 - 2 + 1) + 2);                // [2; 5]
            }
        }
    }

    @Override
    public void depositMoney(Bank bank, Double sum) {
        if (bank != null) {
            bank.setMoney(bank.getMoney() + sum);
        }
    }

    @Override
    public void withdrawMoney(Bank bank, Double sum) {
        if (bank != null) {
            if (bank.getMoney() >= sum) {
                bank.setMoney(bank.getMoney() - sum);
            } else {
                System.out.println("В банке " + bank.getName() + " недостаточно денег для выдачи\n");
            }
        }
    }

    @Override
    public void addClient(Bank bank, User user) {
        if ((bank != null) && (user != null)) {
            user.setBank(bank);
            bank.setCountClient(bank.getCountClient() + 1);
        }
    }

    @Override
    public void removeClient(Bank bank, Integer id) {
        if (bank != null) {

            // Тут должен быть поиск клиента в банке и его удаление, когда в банке появится массив клиентов
            //
            //

            bank.setCountClient(bank.getCountClient() - 1);
        }
    }

    @Override
    public void approvalCredit(Bank bank, CreditAccount account, Employee employee) {
        if ((account != null) && (bank != null) && (employee != null)) {

            Double sum = account.getMoney();

            if (bank.getMoney() >= sum) {
                if (employee.getIsGiveCredit()) {
                    Double sumMonthPay = sum * bank.getInterestRate() / account.getCountMonth();

                    if (account.getUser().getMonthIncome() >= sumMonthPay) {
                        account.setEmployee(employee);
                        account.setMonthPay(sumMonthPay);
                        account.setBank(bank);
                        account.setEmployee(employee);
                        account.setInterestRate(bank.getInterestRate());

                        Calendar dateEnd = (Calendar) account.getDateStart().clone();
                        dateEnd.add(Calendar.MONTH, account.getCountMonth());
                        account.setDateEnd(dateEnd);
                    } else {
                        System.out.println("Отказано в выдаче кредита! " +
                                account.getUser().getName() + " получает меньше ежемесячной выплаты за кредит\n");
                    }
                } else {
                    System.out.println("Отказано в выдаче кредита! " +
                            "Сотрудник " + employee.getName() + " не может оформлять кредиты\n");
                }
            } else {
                System.out.println("Отказано в выдаче кредита! " +
                        "В банке " + bank.getName() + " недостаточно денег для выдачи кредита\n");
            }
        }
    }
}
