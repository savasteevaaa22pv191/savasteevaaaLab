package org.bank.service.impl;

import org.bank.entity.BankAtm;
import org.bank.entity.BankOffice;
import org.bank.entity.Employee;
import org.bank.service.BankOfficeService;
import org.bank.service.BankService;

public class BankOfficeServiceImpl implements BankOfficeService {

    @Override
    public BankOffice create(BankOffice bankOffice) {
        if (bankOffice != null) {

            if (bankOffice.getId() < 0) {
                System.out.println("Ошибка! ID не может быть отрицательным числом!");
                return null;
            }

            if (bankOffice.getMoney() < 0) {
                System.out.println("Ошибка! Кол-во денег не может быть отрицательным числом!");
                return null;
            }

            if (bankOffice.getBank() != null) {
                if (bankOffice.getBank().getMoney() < bankOffice.getMoney()) {
                    System.out.println("Ошибка! Кол-во денег в офисе не может превышать кол-во денег в банке!");
                    return null;
                }
            } else {
                System.out.println("Ошибка! Нельзя создать офис без банка!");
                return null;
            }

            if (bankOffice.getRentPrice() < 0) {
                System.out.println("Ошибка! Стоимость аренды не может быть отрицательным числом!");
                return null;
            }

            BankService bankService = new BankServiceImpl();
            bankService.addOffice(bankOffice.getBank(), bankOffice);

            return new BankOffice(bankOffice);
        }

        return null;
    }

    @Override
    public boolean installAtm(BankOffice bankOffice, BankAtm bankAtm) {
        if ((bankOffice != null) && (bankAtm != null) && (bankOffice.getBank() != null)) {
            if (bankOffice.getIsInstallAtm()) {
                bankOffice.setCountAtm(bankOffice.getCountAtm() + 1);
                bankOffice.getBank().setCountAtm(bankOffice.getBank().getCountAtm() + 1);
                bankAtm.setBankOffice(bankOffice);
                bankAtm.setAddress(bankOffice.getAddress());
                return true;
            } else {
                System.out.println("В офисе " + bankOffice.getName() + " нельзя устанавливать банкоматы");
            }
        }

        return false;
    }

    @Override
    public void uninstallAtm(BankOffice bankOffice, int idAtm) {
        if ((bankOffice != null) && (bankOffice.getBank() != null)) {
            // Тут должен быть поиск банкомата в офисе и его удаление, когда в офисе появится массив банкоматов
            //
            //

            bankOffice.setCountAtm(bankOffice.getCountAtm() - 1);
            bankOffice.getBank().setCountAtm(bankOffice.getBank().getCountAtm() - 1);
        }
    }

    @Override
    public void depositMoney(BankOffice bankOffice, double sum) {
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
    public void withdrawMoney(BankOffice bankOffice, double sum) {
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
    public void addEmployee(BankOffice bankOffice, Employee employee) {
        if ((employee != null) && (bankOffice != null)) {
            employee.setOffice(bankOffice);
            employee.setBank(bankOffice.getBank());
            employee.getBank().setCountEmployee(employee.getBank().getCountEmployee() + 1);
        }
    }

    @Override
    public void removeEmployee(BankOffice bankOffice, int id) {
        if ((bankOffice != null) && (bankOffice.getBank() != null)) {

            // Тут должен быть поиск работника в офисе и его удаление, когда в офисе появится массив работников
            //
            //

            bankOffice.getBank().setCountEmployee(bankOffice.getBank().getCountEmployee() - 1);
        }
    }
}
