package org.bank.service.impl;

import org.bank.entity.Bank;
import org.bank.entity.BankAtm;
import org.bank.entity.BankOffice;
import org.bank.entity.Employee;
import org.bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {

    @Override
    public void installAtm(BankOffice bankOffice, BankAtm bankAtm) {
        if ((bankOffice != null) && (bankAtm != null) && (bankOffice.getBank() != null)) {
            if (bankOffice.getIsInstallAtm()) {
                bankOffice.setCountAtm(bankOffice.getCountAtm() + 1);
                bankOffice.getBank().setCountAtm(bankOffice.getBank().getCountAtm() + 1);
                bankAtm.setBankOffice(bankOffice);
                bankAtm.setAddress(bankOffice.getAddress());
            } else {
                System.out.println("В офисе " + bankOffice.getName() + " нельзя устанавливать банкоматы");
            }
        }
    }

    @Override
    public void uninstallAtm(BankOffice bankOffice, Integer idAtm) {
        if ((bankOffice != null) && (bankOffice.getBank() != null)) {
            // Тут должен быть поиск банкомата в офисе и его удаление, когда в офисе появится массив банкоматов
            //
            //

            bankOffice.setCountAtm(bankOffice.getCountAtm() - 1);
            bankOffice.getBank().setCountAtm(bankOffice.getBank().getCountAtm() - 1);
        }
    }

    @Override
    public void depositMoney(BankOffice bankOffice, Double sum) {
        if ((bankOffice != null) && (bankOffice.getBank() != null)) {

            if (bankOffice.getIsPayInMoney()) {
                bankOffice.setMoney(bankOffice.getMoney() + sum);
                bankOffice.getBank().setMoney(bankOffice.getBank().getMoney() + sum);
            } else {
                System.out.println("В офис " + bankOffice.getName() + " нельзя вносить деньги");
            }
        }
    }

    @Override
    public void withdrawMoney(BankOffice bankOffice, Double sum) {
        if ((bankOffice != null) && (bankOffice.getBank() != null)) {

            if (bankOffice.getIsGiveMoney()) {

                if (bankOffice.getMoney() >= sum) {
                    bankOffice.setMoney(bankOffice.getMoney() - sum);
                    bankOffice.getBank().setMoney(bankOffice.getBank().getMoney() - sum);
                } else {
                    System.out.println("В банкомате " + bankOffice.getBank().getName() + " недостаточно денег для выдачи\n");
                }

            } else {
                System.out.println("Офис " + bankOffice.getName() + " не работает на выдачу денег\n");
            }
        }
    }

    @Override
    public void addEmployee(BankOffice bankOffice, Employee employee, String jobTitle, Double salary,
                            Boolean isRemoteWork, Boolean isGiveCredit) {
        if ((employee != null) && (bankOffice != null)) {
            employee.setOffice(bankOffice);
            employee.setBank(bankOffice.getBank());
            employee.setJobTitle(jobTitle);
            employee.setSalary(salary);
            employee.setRemoteWork(isRemoteWork);
            employee.setIsGiveCredit(isGiveCredit);
            employee.getBank().setCountEmployee(employee.getBank().getCountEmployee() + 1);
        }
    }

    @Override
    public void removeEmployee(BankOffice bankOffice, Integer id) {
        if ((bankOffice != null) && (bankOffice.getBank() != null)) {

            // Тут должен быть поиск работника в офисе и его удаление, когда в офисе появится массив работников
            //
            //

            bankOffice.getBank().setCountEmployee(bankOffice.getBank().getCountEmployee() - 1);
        }
    }
}
