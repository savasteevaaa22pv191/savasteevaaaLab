package org.bank.service.impl;

import org.bank.entity.*;
import org.bank.exception.CreditException;
import org.bank.exception.NotFoundException;
import org.bank.exception.NotUniqueIdException;
import org.bank.service.BankService;
import org.bank.service.CreditAccountService;
import org.bank.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreditAccountServiceImpl implements CreditAccountService {
    private static CreditAccountServiceImpl INSTANCE;
    private final Map<Integer, CreditAccount> creditAccounts = new HashMap<>();

    private CreditAccountServiceImpl() {
    }

    public static CreditAccountServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CreditAccountServiceImpl();
        }

        return INSTANCE;
    }

    private final BankService bankService = BankServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();
    @Override
    public CreditAccount create(CreditAccount creditAccount) throws CreditException, NotUniqueIdException {
        if (creditAccount != null) {

            if (creditAccount.getId() < 0) {
                System.out.println("Ошибка! ID не может быть отрицательным числом!");
                return null;
            }

            if (creditAccount.getMoney() < 0) {
                System.out.println("Ошибка! Кол-во денег не может быть отрицательным числом!");
                return null;
            }

            if (creditAccount.getCountMonth() < 1) {
                System.out.println("Ошибка! Кол-во месяцев не может быть отрицательным числом!");
                return null;
            }

            if (creditAccount.getBank() == null) {
                System.out.println("Ошибка! Нельзя установить процентную ставку кредита без банка!");
                return null;
            }

            if (bankService.approvalCredit(creditAccount.getBank(), creditAccount, creditAccount.getEmployee())) {
                return addCreditAccount(new CreditAccount(creditAccount));
            }
        }

        return null;
    }

    @Override
    public CreditAccount addCreditAccount(CreditAccount creditAccount) throws NotUniqueIdException {
        if (creditAccount != null) {
            if (!creditAccounts.containsKey(creditAccount.getId())) {
                if (userService.addCreditAccount(creditAccount.getUser().getId(), creditAccount)) {
                    creditAccounts.put(creditAccount.getId(), creditAccount);
                    return creditAccounts.get(creditAccount.getId());
                }
            } else {
                throw new NotUniqueIdException(creditAccount.getId());
            }
        } else {
            System.out.println("Нельзя добавить кредитный аккаунт: кредитный аккаунт не может быть null");
        }

        return null;
    }

    @Override
    public CreditAccount getCreditAccountById(int creditAccountId) throws NotFoundException {
        CreditAccount creditAccount = creditAccounts.get(creditAccountId);

        if (creditAccount == null) {
            throw new NotFoundException(creditAccountId);
        }

        return creditAccount;
    }

    @Override
    public boolean deleteCreditAccountById(int creditAccountId) {
        CreditAccount creditAccount = creditAccounts.get(creditAccountId);
        if (creditAccount != null) {
            if (userService.deleteCreditAccount(creditAccount.getUser().getId(), creditAccountId)) {
                return creditAccounts.remove(creditAccountId) != null;
            }
        }
        return false;
    }

    @Override
    public List<CreditAccount> getAllCreditAccount() {
        return null;
    }

    @Override
    public List<CreditAccount> getAllCreditAccountByIdUser(int userId) {
        List<CreditAccount> creditAccountsByUser = creditAccounts.values().stream().filter(
                creditAccount -> creditAccount.getUser().getId() == userId).toList();

        return creditAccountsByUser;
    }

    @Override
    public String read(int creditAccountId) {
        CreditAccount creditAccount = creditAccounts.get(creditAccountId);
        if (creditAccount != null) {
            return creditAccount.toString();
        }
        return "";
    }

    @Override
    public void monthlyPayment(CreditAccount account) {
        if ((account != null) && (account.getPaymentAccount() != null)) {

            if (account.getRemainingSum() > 0) {
                double monthPay = account.getMonthPay();
                double moneyAccount = account.getPaymentAccount().getMoney();

                if (moneyAccount >= monthPay) {
                    account.getPaymentAccount().setMoney(moneyAccount - monthPay);
                    account.setRemainingSum(account.getRemainingSum() - monthPay);
                } else {
                    System.out.println("Отказано в ежемесячном погашении! Не хватает денег\n");
                }
            } else {
                System.out.println("Отказано в ежемесячном погашении! Кредит уже погашен\n");
            }
        }
    }
}
