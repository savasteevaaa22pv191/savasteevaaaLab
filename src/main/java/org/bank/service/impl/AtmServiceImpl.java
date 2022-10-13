package org.bank.service.impl;

import org.bank.entity.Bank;
import org.bank.entity.BankAtm;
import org.bank.entity.BankOffice;
import org.bank.service.AtmService;
import org.bank.utils.Status;

public class AtmServiceImpl implements AtmService {

    @Override
    public void depositMoney(BankAtm bankAtm, Double sum) {
        if ((bankAtm != null) && (bankAtm.getBankOffice() != null) && (bankAtm.getBank() != null)) {

            if (bankAtm.getStatus() != Status.NOT_WORK) {
                if (bankAtm.getIsPayInMoney()) {
                    BankOffice office = bankAtm.getBankOffice();
                    Bank bank = bankAtm.getBank();
                    Double newSum = bankAtm.getMoney() + sum;

                    bankAtm.setMoney(newSum);
                    office.setMoney(office.getMoney() + newSum);
                    bank.setMoney(bank.getMoney() + newSum);
                } else {
                    System.out.println("В банкомат " + bankAtm.getName() + " нельзя вносить деньги\n");
                }
            } else {
                System.out.println("Банкомат " + bankAtm.getName() + " не работает\n");
            }
        }
    }

    @Override
    public void withdrawMoney(BankAtm bankAtm, Double sum) {
        if ((bankAtm != null) && (bankAtm.getBankOffice() != null) && (bankAtm.getBank() != null)) {

            if (bankAtm.getStatus() == Status.WORK) {
                if (bankAtm.getIsGiveMoney()) {
                    if (bankAtm.getMoney() >= sum) {

                        BankOffice office = bankAtm.getBankOffice();
                        Bank bank = bankAtm.getBank();
                        Double newSum = bankAtm.getMoney() - sum;

                        bankAtm.setMoney(newSum);
                        office.setMoney(office.getMoney() + newSum);
                        bank.setMoney(bank.getMoney() + newSum);
                    } else {
                        System.out.println("В банкомате" + bankAtm.getName() + " недостаточно денег для выдачи\n");
                    }
                } else {
                    System.out.println("Банкомат " + bankAtm.getName() + " не работает на выдачу денег\n");
                }
            }
        }
    }
}
