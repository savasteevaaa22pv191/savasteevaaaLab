package org.bank.service.impl;

import org.bank.entity.Bank;
import org.bank.entity.BankOffice;
import org.bank.entity.Employee;
import org.bank.service.EmployeeService;

import java.util.Objects;

public class EmployeeServiceImpl implements EmployeeService {

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
