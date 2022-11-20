package org.bank.service.impl;

import org.bank.entity.Bank;
import org.bank.entity.BankOffice;
import org.bank.entity.Employee;
import org.bank.service.BankService;
import org.bank.service.EmployeeService;

import java.util.Objects;

public class EmployeeServiceImpl implements EmployeeService {
    BankService bankService = new BankServiceImpl();

    @Override
    public Employee create(Employee employee) {
        if (employee != null) {

            if (employee.getId() < 0) {
                System.out.println("Ошибка! ID не может быть отрицательным числом!");
                return null;
            }

            if (employee.getSalary() < 0) {
                System.out.println("Ошибка! Зарплата не может быть отрицательным числом! Или может?");
                return null;
            }

            if (employee.getOffice() == null) {
                System.out.println("Ошибка! Нельзя создать работника без офиса");
                return null;
            }

            bankService.addEmployee(employee.getOffice().getBank(), employee);

            return new Employee(employee);
        }

        return null;
    }

    @Override
    public void transferEmployee(Employee employee, BankOffice bankOffice) {
        if ((employee != null) && (bankOffice != null) && (employee.getBank() != null) && (bankOffice.getBank() != null)) {
            employee.setOffice(bankOffice);

            Bank currentBank = employee.getBank();
            Bank purposeBank = bankOffice.getBank();

            if (!Objects.equals(currentBank.getId(), purposeBank.getId())) {
                employee.setBank(purposeBank);
                currentBank.setCountEmployee(currentBank.getCountEmployee() - 1);
                purposeBank.setCountEmployee(purposeBank.getCountEmployee() + 1);
            }
        }
    }
}
