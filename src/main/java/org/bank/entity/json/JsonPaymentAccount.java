package org.bank.entity.json;

import org.bank.entity.PaymentAccount;

public class JsonPaymentAccount {
	private Integer id;
	private Integer bankID;
	private Integer userID;
	private Double money;

	public JsonPaymentAccount(PaymentAccount payAcc) {
		this.id = payAcc.getId();
		this.bankID = payAcc.getBank().getId();
		this.userID = payAcc.getUser().getId();
		this.money = payAcc.getMoney();
	}

	public Integer getId() {return id;}

	public void setId(Integer id) {this.id = id;}

	public Integer getBankID() {return bankID;}

	public void setBankID(Integer bankID) {this.bankID = bankID;}

	public Integer getUserID() {return this.userID;}

	public void setUserID(Integer userID) {this.userID = userID;}

	public Double getMoney() {return this.money;}

	public void setMoney(Double money) {this.money = money;}
}
