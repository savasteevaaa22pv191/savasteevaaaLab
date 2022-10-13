package org.bank.service.impl;

import org.bank.entity.PaymentAccount;
import org.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    @Override
    public void depositMoney(PaymentAccount account, Double sum) {
        if (account != null) {
            account.setMoney(account.getMoney() + sum);
        }
    }

    @Override
    public void withdrawMoney(PaymentAccount account, Double sum) {
        if (account != null) {
            if (account.getMoney() >= sum) {
                account.setMoney(account.getMoney() - sum);
            } else {
                System.out.println("На аккаунте не достаточно денег для снятия\n");
            }
        }
    }
}
