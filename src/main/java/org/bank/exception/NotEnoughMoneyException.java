package org.bank.exception;

public class NotEnoughMoneyException extends Exception {
	public NotEnoughMoneyException() {
		super("Ошибка! Недостаточно денег");
	}
}
