package org.bank.service.impl;

import org.bank.entity.User;
import org.bank.service.BankService;
import org.bank.service.UserService;

import java.util.Random;

public class UserServiceImpl implements UserService {
    @Override
    public User create(User user) {
        if (user != null) {
            if (user.getId() < 0) {
                System.out.println("Ошибка! ID не может быть отрицательным числом!");
                return null;
            }

            if (!((user.getMonthIncome() > 0) && (user.getMonthIncome() <= 10000))) {
                System.out.println("Ошибка! Ежемесячный дохож не может быть отрицательным числом и не может превышать 10000!");
                return null;
            }

            if (user.getBank() == null) {
                System.out.println("Ошибка! Нельзя создать пользователя без банка");
                return null;
            }

            BankService bankService = new BankServiceImpl();
            bankService.addClient(user.getBank(), user);

            return new User(user);
        }

        return null;
    }

    @Override
    public void jobRegistration(User user, String addressJob, double monthIncome) {
        if (user != null) {
            user.setAddressJob(addressJob);
            user.setMonthIncome(monthIncome);
            calculateRating(user);
        }
    }

    @Override
    public void calculateRating(User user) {
        int low = (int) user.getMonthIncome() / 10;
        int high = low + 100;
        user.setCreditRating(new Random().nextInt(high - low + 1) + low);
    }
}
