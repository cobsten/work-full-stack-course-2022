package org.example.spring.service;

public class PaymentGatewayServiceImpl implements PaymentGatewayService{
    Payment payment;

//    public PaymentGatewayServiceImpl(Payment payment){
//        this.payment = payment;
//    }

    @Override
    public void pay() {
        payment.makePayment();
    }

    public void setPayment(Payment payment){
        this.payment = payment;
    }
}
