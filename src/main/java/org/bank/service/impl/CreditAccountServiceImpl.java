package org.bank.service.impl;

import org.bank.entity.CreditAccount;
import org.bank.service.BankService;
import org.bank.service.CreditAccountService;

public class CreditAccountServiceImpl implements CreditAccountService {
    @Override
    public CreditAccount create(CreditAccount creditAccount) {
        if (creditAccount != null) {

            if (creditAccount.getId() < 0) {
                System.out.println("Ошибка! ID не может быть отрицательным числом!");
                return null;
            }

            if (creditAccount.getMoney() < 0) {
                System.out.println("Ошибка! Кол-во денег не может быть отрицательным числом!");
                return null;
            }

            if (creditAccount.getCountMonth() < 1) {
                System.out.println("Ошибка! Кол-во месяцев не может быть отрицательным числом!");
                return null;
            }

            if (creditAccount.getBank() == null) {
                System.out.println("Ошибка! Нельзя установить процентную ставку кредита без банка!");
                return null;
            }

            BankService bankService = new BankServiceImpl();
            if (bankService.approvalCredit(creditAccount.getBank(), creditAccount, creditAccount.getEmployee())) {
                return new CreditAccount(creditAccount);
            }
        }

        return null;
    }

    @Override
    public void monthlyPayment(CreditAccount account) {
        if ((account != null) && (account.getPaymentAccount() != null)) {

            if (account.getRemainingSum() > 0) {
                double monthPay = account.getMonthPay();
                double moneyAccount = account.getPaymentAccount().getMoney();

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
