package org.bank.service;

import org.bank.entity.BankOffice;
import org.bank.entity.Employee;
import org.bank.exception.NotFoundException;
import org.bank.exception.NotUniqueIdException;

import java.util.List;

public interface EmployeeService {
    /** Создание работника **/
    Employee create(Employee employee) throws NotFoundException, NotUniqueIdException;

    /**
     * Добавление работника
     * Возвращает добавленный объект при успешном выполнении операции;
     * Если employee равен null или уже существует в массиве, возвращает null
     **/
    public Employee addEmployee(Employee employee) throws NotFoundException, NotUniqueIdException;

    /**
     * Получение работника по id
     * Если объект не найден, возвращает null
     **/
    public Employee getEmployeeById(int employeeId);

    /**
     * Удаление работника по id
     * Возвращает true при успешном выполнении операции, иначе false
     * При удалении банка удаляются все офисы банка
     **/
    public Boolean deleteEmployeeById(int employeeId) throws NotFoundException;

    /**
     * Получение всех работников
     **/
    public List<Employee> getAllEmployees();

    /**
     * Получение всех работников определенного банка
     **/
    public List<Employee> getAllEmployeeByIdBank(int bankId);

    /**
     * Получение всех работников определенного банкомата
     **/
    public List<Employee> getAllEmployeeByIdBankOffice(int bankOfficeId);

    /**
     * Вывод подробной информации о работнике
     */
    public String read(int employeeId);

    /**
    Перевод работника в другой офис.
    При этом, если работника переводят в офис другого банка, количество работников соответствующих офисов меняется.
     **/
    void transferEmployee(Employee employee, BankOffice bankOffice);

    /**
     * Возвращает true, если работник подходит для выдачи кредита
     */

    boolean isEmployeeSuitable(Employee employee);
}
