package org.example.spring.service;

public class WalletPaymentImpl implements Payment {
    public void makePayment() {
        System.out.println("Paid using Wallet payment method");
    }
}
