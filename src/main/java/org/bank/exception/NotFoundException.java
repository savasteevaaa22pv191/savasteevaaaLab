package org.bank.exception;

public class NotFoundException extends Exception {
	public NotFoundException(int id) {
		super("Ошибка! Объект с id = " + id + " не существует");
	}
}
