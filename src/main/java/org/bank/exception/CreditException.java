package org.bank.exception;

import org.bank.entity.User;

public class CreditException extends Exception {
	public CreditException() {
		super("Ошибка выдачи кредита!");
	}
}
