package com.payment.application;

public class creditCard implements PaymentX {

    private String cardNumber;
    private String cardHolder;
    private double credit;

    public creditCard(String cardNumber, String cardHolder, double credit) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.credit = credit;
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
