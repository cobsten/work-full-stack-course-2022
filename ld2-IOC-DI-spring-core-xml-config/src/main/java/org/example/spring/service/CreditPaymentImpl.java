package org.example.spring.service;

public class CreditPaymentImpl implements Payment {

    public void makePayment() {
        System.out.println("Paid using Credit payment method");
    }
}
