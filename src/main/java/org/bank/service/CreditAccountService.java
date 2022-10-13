package org.bank.service;

import org.bank.entity.Bank;
import org.bank.entity.CreditAccount;
import org.bank.entity.Employee;

public interface CreditAccountService {
    /*
    Списание ежемесячной оплаты для погашения кредита.
    В опреации может быть отказано, если на платежном аккаунте недостаточно средств или кредит уже погашен.
     */
    void monthlyPayment(CreditAccount account);
}
