package org.bank.service.impl;

import org.bank.entity.User;
import org.bank.service.UserService;

import java.util.Random;

public class UserServiceImpl implements UserService {
    @Override
    public void jobRegistration(User user, String addressJob, Double monthIncome) {
        if (user != null) {
            user.setAddressJob(addressJob);
            user.setMonthIncome(monthIncome);
            calculateRating(user);
        }
    }
    @Override
    public void calculateRating(User user) {
        Integer low = user.getMonthIncome().intValue() / 10;
        Integer high = low + 100;
        user.setCreditRating(new Random().nextInt(high - low + 1) + low);
    }
}
