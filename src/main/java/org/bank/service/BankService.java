package org.bank.service;

import org.bank.entity.*;
import org.bank.exception.NotEnoughMoneyException;
import org.bank.exception.NotFoundException;
import org.bank.exception.CreditException;
import org.bank.exception.NotUniqueIdException;

import java.util.List;

public interface BankService {
	/**
	 * Создание банка
	 **/
	Bank create(Bank bank) throws NotUniqueIdException;

	/**
	 * Добавление банка
	 * Возвращает добавленный объект при успешном выполнении операции;
	 * Если bank равен null или уже существует в массиве, возвращает null
	 **/
	public Bank addBank(Bank bank) throws NotUniqueIdException;

	/**
	 * Получение банка по id
	 * Если объект не найден, возвращает null
	 **/
	public Bank getBankById(int bankId) throws NotFoundException;

	/**
	 * Удаление банка по id
	 * Возвращает true при успешном выполнении операции, иначе false
	 * При удалении банка удаляются все офисы банка
	 **/
	public Boolean deleteBankById(int bankId) throws NotFoundException, NotEnoughMoneyException;

	/**
	 * Получение всех банков
	 **/
	public List<Bank> getAllBanks();

	/**
	 * Вывод подробной информации о банке
	 */
	public String read(int bankId) throws NotFoundException;

	/**
	 * Вычисление процентной ставки банка (зависит от общей суммы денег в банке: чем больше денег - тем меньше ставка).
	 **/
	void calculateInterestRate(Bank bank);

	/**
	 * Внести деньги sum в банк.
	 **/
	void depositMoney(int bankId, double sum) throws NotFoundException;

	/**
	 * Снять деньги sum из банка.
	 * В операции может быть отказано, если в банке недостаточно денег.
	 **/
	void withdrawMoney(int bankId, double sum) throws NotFoundException, NotEnoughMoneyException;

	/**
	 * Добавление клиента user в банк bank
	 **/
	Boolean addClient(int bankId, User user) throws NotFoundException;

	/**
	 * Удаление клиента банка по ID
	 **/
	Boolean deleteClient(int bankId, int id) throws NotFoundException;

	/**
	 * Добавить работника
	 **/
	Boolean addEmployee(int bankId, Employee employee) throws NotFoundException;

	/**
	 * Удалить работника
	 **/
	Boolean deleteEmployee(int bankId, int id) throws NotFoundException;

	/**
	 * Добавление офиса в банк
	 * При этом увеличивается кол-во офисов и банкоматов в банке, а также сумма денег
	 **/
	void addOffice(int bankId, BankOffice bankOffice) throws NotFoundException;

	/**
	 * Удаление офиса
	 * Не может удалить офис, если кол-во офисов = 0
	 * При удалении уменьшает кол-во офисов и банкоматов у банка, а также снимает все деньги, лежащие в офисе
	 **/
	Boolean deleteOffice(int bankId, int bankOfficeId) throws NotFoundException, NotEnoughMoneyException;

	/**
	 * Одобрение заявки на кредит.
	 * В операции может быть отказано, если в банке недостаточно денег, сотрудник employee не выдает кредиты или
	 * зп клиента меньше, чем ежемесячная выплата по кредиту
	 * Если операция проходит успешно, в account автоматически заполняется поле dateEnd.
	 **/
	boolean approvalCredit(Bank bank, CreditAccount account, Employee employee) throws CreditException;

	/**
	 * Возвращает массив банков, подходящих под условия
	 */

	List<Bank> getBanksSuitable(double sum, int countMonth) throws CreditException;

	boolean isBankSuitable(Bank bank, double money);

	List<BankOffice> getBankOfficeSuitableInBank(Bank bank, double money);
}
