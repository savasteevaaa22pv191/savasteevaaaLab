package org.bank.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User extends Person {
	private String addressJob;
	private double monthIncome;
	private Bank bank;
	private int countCreditAccount;
	private int countPaymentAccount;
	private int creditRating;

	public User() {
		super();
		addressJob = "";
		monthIncome = 0.0;
		bank = null;
		countCreditAccount = 0;
		countPaymentAccount = 0;
		creditRating = 0;
	}

	public User(int id, String name, LocalDate dateBirth, double monthIncome, String addressJob, Bank bank) {
		super(id, name, dateBirth);
		this.addressJob = addressJob;
		this.monthIncome = monthIncome;
		this.bank = bank;
		creditRating = 0;
	}

	public User(User user) {
		super(user.getId(), user.getName(), user.getDateBirth());
		this.addressJob = user.getAddressJob();
		this.monthIncome = user.getMonthIncome();
		this.bank = user.getBank();
		countPaymentAccount = user.getCountPaymentAccount();
		countCreditAccount = user.getCountCreditAccount();
		creditRating = user.getCreditRating();
	}

	@Override
	public String toString() {

		return "ID пользователя: " + id + "\n" +
				"Имя пользователя: " + name + " \n" +
				"Дата рождения: " + dateBirth.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n" +
				"Работа: " + addressJob + "\n" +
				"Ежемесячный доход: " + String.format("%.4f", monthIncome) + "\n" +
				"Банк: " + (bank != null ? bank.getName() : "") + "\n" +
				"Кол-во кредитных аккаунтов: " + countCreditAccount + "\n" +
				"Кол-во платежных аккаунтов: " + countPaymentAccount + "\n" +
				"Кредитный рейтинг: " + creditRating + "\n";
	}

	public void setAddressJob(String address) {
		addressJob = address;
	}

	public String getAddressJob() {
		return addressJob;
	}

	public void setMonthIncome(double monthIncome) {
		this.monthIncome = monthIncome;
	}

	public double getMonthIncome() {
		return monthIncome;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Bank getBank() {
		return bank;
	}

	public void setCountCreditAccount(int count) {
		countCreditAccount = count;
	}

	public int getCountCreditAccount() {
		return countCreditAccount;
	}

	public void setCountPaymentAccount(int count) {
		countPaymentAccount = count;
	}

	public int getCountPaymentAccount() {
		return countPaymentAccount;
	}

	public void setCreditRating(int rating) {
		creditRating = rating;
	}

	public int getCreditRating() {
		return creditRating;
	}
}
