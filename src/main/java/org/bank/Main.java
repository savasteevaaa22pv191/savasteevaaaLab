package org.bank;

import org.bank.entity.*;
import org.bank.service.*;
import org.bank.service.impl.*;
import org.bank.utils.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BankServiceImpl bankService = BankServiceImpl.getInstance();
		BankOfficeServiceImpl bankOfficeService = BankOfficeServiceImpl.getInstance();
		AtmServiceImpl atmService = AtmServiceImpl.getInstance();
		UserServiceImpl userService = UserServiceImpl.getInstance();
		EmployeeServiceImpl employeeService = EmployeeServiceImpl.getInstance();
		PaymentAccountServiceImpl paymentAccountService = PaymentAccountServiceImpl.getInstance();
		CreditAccountServiceImpl creditAccountService = CreditAccountServiceImpl.getInstance();

		bankService.create(new Bank(1, "Солнышко"));
		bankService.create(new Bank(2, "Черемуха"));
		bankService.create(new Bank(3, "Вишня"));
		bankService.create(new Bank(4, "Кактус"));
		bankService.create(new Bank(5, "ВТБ"));

		// Создание по 3 офиса в каждом банке
		List<Bank> banks = bankService.getAllBanks();
		Random random = new Random();
		int id = 1;
		for (Bank bank : banks) {
			bankOfficeService.create(new BankOffice(
					id, "Офис " + id + " банка " + bank.getName(), "Пушкина " + id, bank, true,
					true, true, true, true, random.nextInt(1000) + 1000,
					random.nextInt(100) + 50));
			id += 1;

			bankOfficeService.create(new BankOffice(
					id, "Офис " + id + " банка " + bank.getName(), "Пушкина " + id, bank, true,
					true, false, false, true, random.nextInt(4000) + 1000,
					random.nextInt(100) + 30));
			id += 1;

			bankOfficeService.create(new BankOffice(
					id, "Офис " + id + " банка " + bank.getName(), "Пушкина " + id, bank, true,
					true, true, false, true, random.nextInt(3000) + 1000,
					random.nextInt(100) + 200));
			id += 1;
		}

		// Создание по 2 банкомата в каждом офисе
		List<BankOffice> bankOffices = bankOfficeService.getAllBankOffice();
		id = 1;
		for (BankOffice bankOffice : bankOffices) {
			atmService.create(new BankAtm(
					id, "Банкомат " + id + " офиса " + bankOffice.getName(), Status.WORK, true,
					true, random.nextInt(1000) + 500, random.nextInt(100) + 100, bankOffice));

			id += 1;

			atmService.create(new BankAtm(
					id, "Банкомат " + id + " офиса " + bankOffice.getName(), Status.WORK, false,
					true, random.nextInt(1000) + 500, random.nextInt(100) + 100, bankOffice));

			id += 1;
		}

		// Создание по 5 работников в каждом офисе
		id = 1;
		for (BankOffice bankOffice : bankOffices) {
			employeeService.create(new Employee(
					id, "Работник " + id + " офиса " + bankOffice.getName(),
					LocalDate.of(2001, random.nextInt(11) + 1 , random.nextInt(27) + 1),
					"должность", true, bankOffice, true, random.nextInt(5000) + 1000));
			id += 1;

			employeeService.create(new Employee(
					id, "Работник " + id + " офиса " + bankOffice.getName(),
					LocalDate.of(2004, random.nextInt(11) + 1, random.nextInt(27) + 1),
					"должность", true, bankOffice, true, random.nextInt(3000) + 1000));
			id += 1;

			employeeService.create(new Employee(
					id, "Работник " + id + " офиса " + bankOffice.getName(),
					LocalDate.of(2004, random.nextInt(11) + 1, random.nextInt(27) + 1),
					"должность", false, bankOffice, false, random.nextInt(2000) + 3000));
			id += 1;

			employeeService.create(new Employee(
					id, "Работник " + id + " офиса " + bankOffice.getName(),
					LocalDate.of(2004, random.nextInt(11) + 1, random.nextInt(27) + 1),
					"должность", false, bankOffice, true, random.nextInt(5000) + 1000));
			id += 1;

			employeeService.create(new Employee(
					id, "Работник " + id + " офиса " + bankOffice.getName(),
					LocalDate.of(2004, random.nextInt(11) + 1, random.nextInt(27) + 1),
					"должность", true, bankOffice, false, random.nextInt(5000) + 2000));
			id += 1;
		}

		// Создание по 2 пользователя в банке
		id = 1;
		for (Bank bank: banks) {
			userService.create(new User(
					id, "Пользователь " + id + " банка " + bank.getName(),
					LocalDate.of(2004, random.nextInt(11) + 1,
							random.nextInt(27) + 1), random.nextInt(3000) + 2000,
					"адрес работы", bank));

			id += 1;

			userService.create(new User(
					id, "Пользователь " + id + " банка " + bank.getName(),
					LocalDate.of(2004, random.nextInt(11) + 1,
							random.nextInt(27) + 1), random.nextInt(3000) + 2000,
					"адрес работы", bank));
			id += 1;
		}

		List<User> users = userService.getAllUsers();

		// Создание по 2 платежных аккаунта у каждого пользователя
		id = 1;
		for (User user: users) {
			paymentAccountService.create(new PaymentAccount(id, user, user.getBank(), random.nextInt(4000) + 2000));
			id += 1;
			paymentAccountService.create(new PaymentAccount(id, user, user.getBank(), random.nextInt(4000) + 2000));
			id += 1;
		}

		// Создание по 2 кредитных аккаунта у каждого пользователя
		id = 1;
		for (User user: users) {
			List<Employee> employees = employeeService.getAllEmployeeByIdBank(user.getBank().getId());
			List<PaymentAccount> paymentAccounts = paymentAccountService.getAllPaymentAccountByIdUser(user.getId());
			creditAccountService.create(new CreditAccount(id, user, user.getBank(),
					LocalDate.of(2004, random.nextInt(11) + 1, random.nextInt(27) + 1),
					random.nextInt(10) + 1,
					random.nextInt(4000) + 1000,
					employeeService.getEmployeeById(random.nextInt(employees.size() + 1)),
					paymentAccountService.getPaymentAccountById(random.nextInt(paymentAccounts.size() + 1))
					));
			id += 1;
			creditAccountService.create(new CreditAccount(id, user, user.getBank(),
					LocalDate.of(2004, random.nextInt(11) + 1, random.nextInt(27) + 1),
					random.nextInt(10) + 1,
					random.nextInt(2000) + 1000,
					employeeService.getEmployeeById(random.nextInt(employees.size() + 1)),
					paymentAccountService.getPaymentAccountById(random.nextInt(paymentAccounts.size() + 1))
			));
			id += 1;
		}

		// Опция вывода информации о банке
		Scanner in = new Scanner(System.in);
		List<Bank> banksList = bankService.getAllBanks();
		StringBuilder bankOption = new StringBuilder("************************************\n");
		bankOption.append("Введите id банка для вывода подробной информации\n");
		bankOption.append("Введите -1 для выхода\n");
		bankOption.append("ID существующих банков: ");
		for (Bank bank: banksList) {
			bankOption.append(bank.getId()).append("  ");
		}
		bankOption.append("\n************************************\n");
		System.out.println(bankOption);

		int inputValue = in.nextInt();
		while (inputValue != -1) {
			System.out.println(bankService.read(inputValue));
			System.out.println(bankOption);
			inputValue = in.nextInt();
		}

		// Опция вывода информации о счетах пользователя
		List<User> usersList = userService.getAllUsers();
		StringBuilder userOption = new StringBuilder("************************************\n");
		userOption.append("Введите id пользователя для вывода подробной информации\n");
		userOption.append("Введите -1 для выхода\n");
		userOption.append("ID существующих пользователей: ");
		for (User user: usersList) {
			userOption.append(user.getId()).append("  ");
		}
		userOption.append("\n************************************\n");
		System.out.println(userOption);

		inputValue = in.nextInt();
		while (inputValue != -1) {
			System.out.println(userService.read(inputValue));
			System.out.println(userOption);
			inputValue = in.nextInt();
		}
	}
}