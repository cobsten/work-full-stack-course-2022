package org.example.nospring;

import org.example.nospring.service.CreditPaymentServiceImpl;
import org.example.nospring.service.DebitPaymentServiceImpl;
import org.example.nospring.service.PaymentGatewayService;
import org.example.nospring.service.WalletPaymentServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PaymentGatewayService paymentGatewayService = new CreditPaymentServiceImpl();
        paymentGatewayService.pay();

        paymentGatewayService = new DebitPaymentServiceImpl();
        paymentGatewayService.pay();

        paymentGatewayService = new WalletPaymentServiceImpl();
        paymentGatewayService.pay();
    }
}
