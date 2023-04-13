package org.example.spring;

import org.example.spring.service.PaymentGatewayService;
import org.example.spring.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PaymentGatewayService service = context.getBean("paymentGatewayService", PaymentGatewayService.class);
        service.pay();
    }
}
