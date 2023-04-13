package org.example.spring.service;

public class DebitPaymentImpl implements Payment {
    public void makePayment() {
        System.out.println("Paid using Debit payment method");
    }
}
