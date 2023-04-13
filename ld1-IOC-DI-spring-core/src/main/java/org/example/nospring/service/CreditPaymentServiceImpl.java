package org.example.nospring.service;

public class CreditPaymentServiceImpl implements PaymentGatewayService{

    public void pay() {
        System.out.println("Paid using Credit payment method");
    }
}
