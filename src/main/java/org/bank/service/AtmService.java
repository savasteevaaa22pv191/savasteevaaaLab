package org.bank.service;

import org.bank.entity.Bank;
import org.bank.entity.BankAtm;

import java.util.List;

public interface AtmService {
	/**
	 * Создание банкомата
	 **/
	BankAtm create(BankAtm bankAtm);

	/**
	 * Добавление банкомата в массив
	 * Возвращает добавленный объект при успешном выполнении операции;
	 * Если bankAtm равен null или уже существует в массиве, возвращает null
	 * Логика добавления передается в bankOfficeService
	 **/
	BankAtm addBankAtm(BankAtm bankAtm);

	/**
	 * Получение банкомата по id
	 * Если объект не найден, возвращает null
	 **/
	public BankAtm getBankAtmById(int bankAtmId);

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
	Boolean deleteBankAtm(int bankAtmId);

	/**
	 * Вывод подробной информации о банкомате
	 */
	public String read(int bankAtmId);

	/**
	 * Внести деньги в банкомат. Также деньги вносятся в соответствующий офис и банк.
	 * В операции может быть отказано, если банкомат не работает в текущий момент или не работает на внос денег.
	 **/
	void depositMoney(int bankAtmId, double sum);

	/**
	 * Снять деньги из банкомата. Также деньги снимаются из соответствующего офиса и банка.
	 * В операции может быть отказано, если банкомат не работает в текущий момент, не работает на выдачу денег
	 * или в нем недостаточно денег.
	 **/
	void withdrawMoney(int bankAtmId, double sum);

	void updateBank(int id, Bank bank);
}
