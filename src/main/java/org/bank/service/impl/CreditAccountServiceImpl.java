package org.bank.service.impl;

import org.bank.entity.Bank;
import org.bank.entity.CreditAccount;
import org.bank.entity.Employee;
import org.bank.service.CreditAccountService;

import java.util.Calendar;

public class CreditAccountServiceImpl implements CreditAccountService {
    @Override
    public void monthlyPayment(CreditAccount account) {
        if ((account != null) && (account.getPaymentAccount() != null)) {

            if (account.getRemainingSum() > 0) {
                Double monthPay = account.getMonthPay();
                Double moneyAccount = account.getPaymentAccount().getMoney();

                if (moneyAccount >= monthPay) {
                    account.getPaymentAccount().setMoney(moneyAccount - monthPay);
                    account.setRemainingSum(account.getRemainingSum() - monthPay);
                } else {
                    System.out.println("Отказано в ежемесячном погашении! Не хватает денег\n");
                }
            } else {
                System.out.println("Отказано в ежемесячном погашении! Кредит уже погашен\n");
            }
        }
    }
}
