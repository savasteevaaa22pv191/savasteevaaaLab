package org.bank.service;

import org.bank.entity.Bank;
import org.bank.entity.CreditAccount;
import org.bank.entity.PaymentAccount;
import org.bank.entity.User;
import org.bank.exception.NotFoundException;
import org.bank.exception.NotUniqueIdException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserService {

    // Создание пользователя
    User create(User user) throws NotFoundException, NotUniqueIdException;

    /**
     * Добавление пользователя
     *
     **/
    User addUser(User user) throws NotFoundException, NotUniqueIdException;

    /**
     * Получение пользователя по id
     **/
    User getUserById(int userId);

    /**
     * Удаление работника по id
     **/
    boolean deleteUserById(int userId) throws NotFoundException;

    /**
     * Получение всех работников
     **/
    List<User> getAllUsers();

    /**
     * Получение всех пользователей определенного банка
     **/
    public List<User> getAllUserByIdBank(int bankId);

    /**
     * Добавление кредитного аккаунта
     * Увеличивает кол-во кредитных аккаунтов
     */
    boolean addCreditAccount(int userId, CreditAccount creditAccount);

    /**
     * Удаление клиента банка по ID
     **/
    boolean deleteCreditAccount(int userId, int creditAccountId);

    /**
     * Добавление платежного аккаунта
     * Увеличивает кол-во платежных аккаунтов
     */
    boolean addPaymentAccount(int userId, PaymentAccount paymentAccount);

    /**
     * Удаление клиента банка по ID
     **/
    boolean deletePaymentAccount(int userId, int paymentAccountId);

    /**
     * Вывод подробной информации о работнике
     */
    public String read(int userId);

    /**
    Регистрация места работы. При этом подсчитывается кредитный рейтинг пользователя.
     **/
    void jobRegistration(User user, String addressJob, double monthIncome);

    /**
    Подсчет кредитного рейтинга пользователя (генерируется рандомно
    исходя из ежемесячного дохода, от меньше 1 000 – 100, от 1 000 до 2 000 – 200 и т.д. вплоть до 10 000 )
     **/
    void calculateRating(User user);

    PaymentAccount getBestPaymentAccountByUserID(int userId);

    void saveToFileByUserId(String fileName, int bankId, int userId) throws IOException;

    void transfer(String fileName, int bankId, int paymentAccountId, int creditAccountId) throws IOException, NotUniqueIdException, NotFoundException;

    List<Bank> getAllBanksByIdUser(int userId);
}
