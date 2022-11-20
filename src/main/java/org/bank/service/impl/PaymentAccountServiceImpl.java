package org.bank.service.impl;

import org.bank.entity.PaymentAccount;
import org.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    @Override
    public PaymentAccount create(PaymentAccount paymentAccount) {
        if (paymentAccount != null) {

            if (paymentAccount.getId() < 0) {
                System.out.println("Ошибка! ID не может быть отрицательным числом!");
                return null;
            }

            if (paymentAccount.getMoney() < 0) {
                System.out.println("Ошибка! Кол-во денег не может быть отрицательным числом!");
            }

            return new PaymentAccount(paymentAccount);
        }

        return null;
    }

    @Override
    public void depositMoney(PaymentAccount account, double sum) {
        if (account != null) {
            account.setMoney(account.getMoney() + sum);
        }
    }

    @Override
    public void withdrawMoney(PaymentAccount account, double sum) {
        if (account != null) {
            if (account.getMoney() >= sum) {
                account.setMoney(account.getMoney() - sum);
            } else {
                System.out.println("На аккаунте не достаточно денег для снятия\n");
            }
        }
    }
}
