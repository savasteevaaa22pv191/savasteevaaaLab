package org.bank.service;

import org.bank.entity.Bank;
import org.bank.entity.BankOffice;
import org.bank.entity.Employee;

public interface EmployeeService {

    /*
    Перевод работника в другой офис.
    При этом, если работника переводят в офис другого банка, количество работников соответствующих офисов меняется.
     */
    void transferEmployee(Employee employee, BankOffice bankOffice);

}
