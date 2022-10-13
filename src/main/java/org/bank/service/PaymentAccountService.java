package org.bank.service;

import org.bank.entity.BankAtm;
import org.bank.entity.PaymentAccount;

public interface PaymentAccountService {
    /*
    Внести деньги на платежный счет.
    */
    void depositMoney(PaymentAccount account, Double sum);

    /*
    Снять деньги с платежного счета.
    В операции может быть отказано, если на счету недостаточно денег.
    */

    void withdrawMoney(PaymentAccount account, Double sum);
}
