package org.bank;

import org.bank.entity.*;
import org.bank.service.AtmService;
import org.bank.service.impl.*;
import org.bank.utils.Status;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank(1, "Солнышко");
        BankServiceImpl bankService = new BankServiceImpl();
        bankService.calculateInterestRate(bank);
        System.out.println(bank);

        BankOffice bankOffice = new BankOffice(1, "Трудяги", "Буденова 9", bank);
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        bankOffice.setIsWorking(true);
        bankOffice.setIsGiveMoney(true);
        bankOffice.setIsPayInMoney(true);
        bankOffice.setRentPrice(3000D);
        bankOfficeService.depositMoney(bankOffice, 2000D);
        System.out.println(bankOffice);

        Employee employee = new Employee(1, "Roman", new GregorianCalendar(2001, Calendar.NOVEMBER,
                4));
        System.out.println(employee);

        bankOfficeService.addEmployee(bankOffice, employee, "уборщик", 4000D, true,
                false);

        BankAtm bankAtm = new BankAtm(1, "RPG", Status.WORK, bank, bankOffice, employee, true,
                false);
        AtmServiceImpl atmService = new AtmServiceImpl();
        atmService.depositMoney(bankAtm, 5000D);
        bankAtm.setServicePrice(200D);
        System.out.println(bankAtm);

        User user = new User(1, "Maria", new GregorianCalendar(2001, Calendar.JANUARY,
                9));
        UserServiceImpl userService = new UserServiceImpl();
        userService.jobRegistration(user, "Волчанская 2", 9000D);
        System.out.println(user);

        PaymentAccount paymentAccount = new PaymentAccount(1, user);
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        System.out.println(paymentAccount);

        CreditAccount creditAccount = new CreditAccount(1, user, new GregorianCalendar(2022, Calendar.OCTOBER,
                14), 3, 1000D, paymentAccount);
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();

        bankService.approvalCredit(bank, creditAccount, employee);
        employee.setIsGiveCredit(true);
        bankService.approvalCredit(bank, creditAccount, employee);
        System.out.println(creditAccount);
    }
}