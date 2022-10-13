package org.bank.service;

import org.bank.entity.BankAtm;
import org.bank.entity.BankOffice;

public interface AtmService {
    /*
    Внести деньги в банкомат. Также деньги вносятся в соответствующий офис и банк.
    В операции может быть отказано, если банкомат не работает в текущий момент или не работает на внос денег.
    */
    void depositMoney(BankAtm bankAtm, Double sum);

    /*
    Снять деньги из банкомата. Также деньги снимаются из соответствующего офиса и банка.
    В операции может быть отказано, если банкомат не работает в текущий момент, не работает на выдачу денег
    или в нем недостаточно денег.
    */
    void withdrawMoney(BankAtm bankAtm, Double sum);
}
