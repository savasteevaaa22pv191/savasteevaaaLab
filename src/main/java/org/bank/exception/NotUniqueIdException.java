package org.bank.exception;

public class NotUniqueIdException extends Exception {
	public NotUniqueIdException(int id) {
		super("Ошибка! Объекст с id = " + id + " уже существует");
	}
}
