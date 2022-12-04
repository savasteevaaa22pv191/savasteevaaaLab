package org.bank.service.impl;

import org.bank.entity.*;
import org.bank.service.PaymentAccountService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    private static PaymentAccountServiceImpl INSTANCE;
    private final Map<Integer, PaymentAccount> paymentAccounts = new HashMap<>();

    private PaymentAccountServiceImpl() {
    }

    public static PaymentAccountServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PaymentAccountServiceImpl();
        }

        return INSTANCE;
    }

    UserServiceImpl userService = UserServiceImpl.getInstance();
    @Override
    public PaymentAccount create(PaymentAccount paymentAccount) {
        if (paymentAccount != null) {

            if (paymentAccount.getId() < 0) {
                System.out.println("Ошибка! ID не может быть отрицательным числом!");
                return null;
            }

            if (paymentAccount.getMoney() < 0) {
                System.out.println("Ошибка! Кол-во денег не может быть отрицательным числом!");
            }

            return addPaymentAccount(new PaymentAccount(paymentAccount));
        }

        return null;
    }

    @Override
    public PaymentAccount addPaymentAccount(PaymentAccount paymentAccount) {
        if (paymentAccount != null) {
            if (!paymentAccounts.containsKey(paymentAccount.getId())) {
                User user = paymentAccount.getUser();
                if (user != null) {
                    if (userService.addPaymentAccount(user.getId(), paymentAccount)) {
                        paymentAccounts.put(paymentAccount.getId(), paymentAccount);
                        return paymentAccounts.get(paymentAccount.getId());
                    }
                }
            }
        }

        return null;
    }

    @Override
    public PaymentAccount getPaymentAccountById(int paymentAccountId) {
        return paymentAccounts.get(paymentAccountId);
    }

    @Override
    public boolean deletePaymentAccountById(int paymentAccountId) {
        PaymentAccount paymentAccount = paymentAccounts.get(paymentAccountId);
        if (paymentAccount != null) {
            if (userService.deletePaymentAccount(paymentAccount.getUser().getId(), paymentAccountId)) {
                return paymentAccounts.remove(paymentAccountId) != null;
            }
        }
        return false;
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccounts() {
        return new ArrayList<PaymentAccount>(paymentAccounts.values());
    }

    @Override
    public void depositMoney(PaymentAccount account, double sum) {
        if (account != null) {
            account.setMoney(account.getMoney() + sum);
        }
    }

    @Override
    public void withdrawMoney(PaymentAccount account, double sum) {
        if (account != null) {
            if (account.getMoney() >= sum) {
                account.setMoney(account.getMoney() - sum);
            } else {
                System.out.println("На аккаунте не достаточно денег для снятия\n");
            }
        }
    }
    @Override
    public List<PaymentAccount> getAllPaymentAccountByIdUser(int userId) {
        List<PaymentAccount> paymentAccountsByUser = paymentAccounts.values().stream().filter(
                paymentAccount -> paymentAccount.getUser().getId() == userId).toList();

        return paymentAccountsByUser;
    }

    @Override
    public String read(int paymentAccountId) {
        PaymentAccount paymentAccount = paymentAccounts.get(paymentAccountId);
        if (paymentAccount != null) {
            return paymentAccount.toString();
        }
        return "";
    }
}
