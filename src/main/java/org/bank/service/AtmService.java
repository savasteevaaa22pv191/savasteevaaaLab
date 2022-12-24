package org.bank.service;

import org.bank.entity.Bank;
import org.bank.entity.BankAtm;
import org.bank.exception.NotEnoughMoneyException;
import org.bank.exception.NotFoundException;
import org.bank.exception.NotUniqueIdException;

import java.util.List;

public interface AtmService {
	/**
	 * Создание банкомата
	 **/
	BankAtm create(BankAtm bankAtm) throws NotFoundException, NotUniqueIdException;

	/**
	 * Добавление банкомата в массив
	 * Возвращает добавленный объект при успешном выполнении операции;
	 * Если bankAtm равен null или уже существует в массиве, возвращает null
	 * Логика добавления передается в bankOfficeService
	 **/
	BankAtm addBankAtm(BankAtm bankAtm) throws NotFoundException, NotUniqueIdException;

	/**
	 * Получение банкомата по id
	 * Если объект не найден, возвращает null
	 **/
	public BankAtm getBankAtmById(int bankAtmId) throws NotFoundException;

	/**
	 * Получение всех банкоматов
	 **/
	public List<BankAtm> getAllBankAtm();

	/**
	 * Получение всех банкоматов определенного офиса
	 **/
	public List<BankAtm> getAllBankAtmByIdBankOffice(int bankOfficeId);

	/**
	 * Удаление банкомата по id из массива
	 * Логика удаления передается bankOfficeService
	 **/
	Boolean deleteBankAtm(int bankAtmId) throws NotFoundException, NotEnoughMoneyException;

	/**
	 * Вывод подробной информации о банкомате
	 */
	public String read(int bankAtmId) throws NotFoundException;

	/**
	 * Внести деньги в банкомат. Также деньги вносятся в соответствующий офис и банк.
	 * В операции может быть отказано, если банкомат не работает в текущий момент или не работает на внос денег.
	 **/
	void depositMoney(int bankAtmId, double sum) throws NotFoundException;

	/**
	 * Снять деньги из банкомата. Также деньги снимаются из соответствующего офиса и банка.
	 * В операции может быть отказано, если банкомат не работает в текущий момент, не работает на выдачу денег
	 * или в нем недостаточно денег.
	 **/
	void withdrawMoney(int bankAtmId, double sum) throws NotFoundException, NotEnoughMoneyException;

	void updateBank(int id, Bank bank);

	/**
	 * Возвращает true, если банкомат подходит для выдачи денег на кредит
	 */

	boolean isAtmSuitable(BankAtm bankAtm, double money);
}
