package org.bank.service;

import org.bank.entity.*;

public interface BankService {
    /*
    Вычисление процентной ставки банка (зависит от общей суммы денег в банке: чем больше денег - тем меньше ставка).
     */
    void calculateInterestRate(Bank bank);

    /*
    Внести деньги sum в банк.
    */
    void depositMoney(Bank bank, Double sum);

    /*
    Снять деньги sum из банка.
    В операции может быть отказано, если в банке недостаточно денег.
    */
    void withdrawMoney(Bank bank, Double sum);

    /*
    Добавление клиента банка
     */
    void addClient(Bank bank, User user);

    /*
    Удаление клиента банка по ID
     */
    void removeClient(Bank bank, Integer id);

    /*
    Одобрение заявки на кредит.
    В операции может быть отказано, если в банке недостаточно денег, сотрудник employee не выдает кредиты или
    зп клиента меньше, чем ежемесячная выплата по кредиту
    Если операция проходит успешно, в account автоматически заполняется поле dateEnd.
     */
    void approvalCredit(Bank bank, CreditAccount account, Employee employee);
}
