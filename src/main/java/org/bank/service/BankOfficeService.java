package org.bank.service;

import org.bank.entity.*;

import java.util.List;

public interface BankOfficeService {
	/**
	 * Создание офиса банка
	 **/
	BankOffice create(BankOffice bankOffice);

	/**
	 * Добавление офиса банка в массив
	 * Возвращает добавленный объект при успешном выполнении операции;
	 * Если bankOffice равен null или уже существует в массиве, возвращает null
	 * Логика добавления офиса передается bankService
	 **/
	BankOffice addBankOffice(BankOffice bankOffice);

	/**
	 * Получение офиса банка по id
	 * Если объект не найден, возвращает null
	 **/
	public BankOffice getBankOfficeById(int bankOfficeId);

	/**
	 * Получение всех офисов
	 **/
	public List<BankOffice> getAllBankOffice();

	/**
	 * Получение всех офисов банка по его id
	 **/
	public List<BankOffice> getAllBankOfficeByIdBank(int bankId);

	/**
	 * Удаление офиса банка по id
	 * При удалении офиса удаляются все его банкоматы
	 * Логика удаления офиса передается bankService
	 **/
	Boolean deleteBankOffice(int bankOfficeId);

	/**
	 * Вывод подробной информации о банковском офисе
	 */
	public String read(int bankOfficeId);

	/**
	 * Установка банкомата в офисе.
	 * При этом увеличивается кол-во банкоматов и денег в офисе
	 * При этом увеличивается количество банкоматов и денег в соответствующем банке.
	 * В операции может быть отказано, если в офисе запрещена установка банкоматов.
	 **/
	boolean addAtm(int bankOfficeId, BankAtm bankAtm);

	/**
	 * Удаление банкомата из офиса.
	 * При этом уменьшается количество банкоматов и денег в офисе
	 * При этом уменьшается количество банкоматов и денег в соответствующем банке.
	 **/
	Boolean deleteAtm(int bankOfficeId, int idAtm);

	/**
	 * Внести деньги в офис. Также деньги вносятся в соответствующий банк.
	 * В операции может быть отказано, если офис не работает на внос денег.
	 **/
	void depositMoney(int bankOfficeId, double sum);

	/**
	 * Снять деньги из офиса. Также деньги снимаются из соответствующего банка.
	 * В операции может быть отказано, если офис не работает на выдачу денег или в нем недостаточно денег.
	 **/
	void withdrawMoney(int bankOfficeId, double sum);

	/**
	 * Добавление работника в офис
	 * При этом увеличивается количество работников в соответствующем банке
	 **/
	Boolean addEmployee(int bankOfficeId, Employee employee);

	/**
	 * Удаление работника из офиса по ID.
	 * При этом уменьшается количество работников в соответствующем банке
	 **/
	Boolean deleteEmployee(int bankOfficeId, int id);
}
