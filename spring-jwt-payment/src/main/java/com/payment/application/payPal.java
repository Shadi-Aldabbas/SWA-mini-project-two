package com.payment.application;

public class payPal implements PaymentX {

    private String accountName;
    private String balance;

    public payPal(String accountName, String balance) {
        this.accountName = accountName;
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
