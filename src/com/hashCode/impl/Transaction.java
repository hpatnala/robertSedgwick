package com.hashCode.impl;

import java.util.Date;

public class Transaction {
	
	private String who;
	private Date when;
	private double amount;
	
	public static void main(String[] args) {
		Transaction trans = new Transaction();
		trans.setWho("ABC");
		trans.setWhen(new Date());
		trans.setAmount(346.23);
		System.out.println(trans.hashCode());
		Transaction trans2 = new Transaction();
		trans2.setWho("ABC");
		trans2.setWhen(new Date());
		trans2.setAmount(346.23);
		System.out.println(trans.equals(trans2));
	}

	private String getWho() {
		return who;
	}

	private void setWho(String who) {
		this.who = who;
	}

	private Date getWhen() {
		return when;
	}

	private void setWhen(Date when) {
		this.when = when;
	}

	private double getAmount() {
		return amount;
	}

	private void setAmount(double amount) {
		this.amount = amount;
	}
	
	public boolean equals(Object y) {
		return this.hashCode() == ((Transaction)y).hashCode();
	}
	
	public int hashCode() {
		int hash = 17;
		hash = (31 * 17) + getWho().hashCode();
		hash = (31 * 17) + getWhen().hashCode();
		hash = (31 * 17) + ((Double)getAmount()).hashCode();
		return hash;
	}
	
}
