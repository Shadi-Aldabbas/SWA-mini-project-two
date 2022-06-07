package com.payment.application;

public class BankAccount implements PaymentX {

    private String accountNumber;
    private String accountOwner;
    private double balance;

    public BankAccount(String accountNumber, String accountOwner, double balance) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.balance = balance;
    }

    @Override
    public boolean transaction() {
        return false;
    }

    @Override
    public double checkBalance() {
        return 0;
    }

    @Override
    public boolean deposit() {
        return false;
    }
}
