package org.example.nospring.service;

public class WalletPaymentServiceImpl implements PaymentGatewayService{
    public void pay() {
        System.out.println("Paid using Wallet payment method");
    }
}
