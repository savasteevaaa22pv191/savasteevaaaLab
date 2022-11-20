package org.bank;

import org.bank.entity.*;
import org.bank.service.*;
import org.bank.service.impl.*;
import org.bank.utils.Status;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        Bank bank = bankService.create(new Bank(1, "Солнышко"));
        System.out.println(bank);


        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        BankOffice bankOffice = bankOfficeService.create(new BankOffice(1, "Трудяги", "Буденова 9",
                bank, true, true, true, true, true,
                10000, 200));
        System.out.println(bankOffice);


        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService.create(new Employee(1, "Roman", LocalDate.of(2001, 10, 4),
                        "Уборщик", true, bankOffice, true, 1000));
        System.out.println(employee);


        AtmService atmService = new AtmServiceImpl();
        BankAtm bankAtm = atmService.create(new BankAtm(1, "RPG", Status.WORK, true,
                true, 5000, 200, bankOffice));
        System.out.println(bankAtm);


        UserService userService = new UserServiceImpl();
        User user = userService.create(new User(1, "Maria", LocalDate.of(2001, 2,
                9), 9000, "Волчанская 2", bank));
        System.out.println(user);


        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        PaymentAccount paymentAccount = paymentAccountService.create(new PaymentAccount(1, user, bank, 4000));
        System.out.println(paymentAccount);


        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        CreditAccount creditAccount = creditAccountService.create(new CreditAccount(1, user, bank,
                LocalDate.of(2001, 2, 9), 4, 1000, employee, paymentAccount));
        System.out.println(creditAccount);

        System.out.println(bank);

    }
}