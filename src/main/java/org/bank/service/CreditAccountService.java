package org.bank.service;

import org.bank.entity.CreditAccount;

public interface CreditAccountService {
    // Создание кредитного аккаунта
    CreditAccount create(CreditAccount creditAccount);

    /*
    Списание ежемесячной оплаты для погашения кредита.
    В опреации может быть отказано, если на платежном аккаунте недостаточно средств или кредит уже погашен.
     */
    void monthlyPayment(CreditAccount account);
}
