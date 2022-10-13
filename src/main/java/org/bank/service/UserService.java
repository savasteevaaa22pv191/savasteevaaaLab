package org.bank.service;

import org.bank.entity.User;

public interface UserService {
    /*
    Регистрация места работы. При этом подсчитывается кредитный рейтинг пользователя.
     */
    void jobRegistration(User user, String addressJob, Double monthIncome);

    /*
    Подсчет кредитного рейтинга пользователя (генерируется рандомно
    исходя из ежемесячного дохода, от меньше 1 000 – 100, от 1 000 до 2 000 – 200 и т.д. вплоть до 10 000 )
     */
    void calculateRating(User user);
}
