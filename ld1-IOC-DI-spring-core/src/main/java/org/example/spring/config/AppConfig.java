package org.example.spring.config;

import org.example.spring.service.*;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean("payment")
    Payment getPayment(){
        return new WalletPaymentImpl();
    }

    @Bean("paymentGatewayService")
    PaymentGatewayService getPaymentGatewayService(Payment payment){
        return new PaymentGatewayServiceImpl(payment);
    }
}
