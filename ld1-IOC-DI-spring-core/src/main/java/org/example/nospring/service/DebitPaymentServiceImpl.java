package org.example.nospring.service;

public class DebitPaymentServiceImpl implements PaymentGatewayService{
    public void pay() {
        System.out.println("Paid using Debit payment method");
    }
}
