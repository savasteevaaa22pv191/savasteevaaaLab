package org.bank.service.impl;

import org.bank.entity.*;
import org.bank.service.BankOfficeService;
import org.bank.service.EmployeeService;

import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeServiceImpl INSTANCE;
    private final Map<Integer, Employee> employees = new HashMap<>();

    private EmployeeServiceImpl() {
    }

    public static EmployeeServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmployeeServiceImpl();
        }

        return INSTANCE;
    }

    private final BankOfficeService bankOfficeService = BankOfficeServiceImpl.getInstance();

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

            return addEmployee(new Employee(employee));
        }

        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee != null) {

            if (!employees.containsKey(employee.getId())) {
                BankOffice bankOffice = employee.getOffice();
                if (bankOffice != null) {
                    if (bankOfficeService.addEmployee(bankOffice.getId(), employee)) {
                        employees.put(employee.getId(), employee);
                        return employees.get(employee.getId());
                    }
                }
            }
        }

        return null;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employees.get(employeeId);
    }

    @Override
    public Boolean deleteEmployeeById(int employeeId) {
        Employee employee = employees.get(employeeId);
        if (employee != null) {
            if (bankOfficeService.deleteEmployee(employee.getOffice().getId(), employeeId)) {
                return employees.remove(employeeId) != null;
            }
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<Employee>(employees.values());
    }

    @Override
    public List<Employee> getAllEmployeeByIdBank(int bankId) {
        List<Employee> employeeByBank = employees.values().stream().filter(
                employee -> employee.getBank().getId() == bankId).toList();

        return employeeByBank;
    }

    @Override
    public List<Employee> getAllEmployeeByIdBankOffice(int bankOfficeId) {
        List<Employee> employeeByBankOffice = employees.values().stream().filter(
                employee -> employee.getOffice().getId() == bankOfficeId).toList();

        return employeeByBankOffice;
    }

    @Override
    public String read(int employeeId) {
        Employee employee = employees.get(employeeId);
        if (employee != null) {
            return employee.toString();
        }
        return "";
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
