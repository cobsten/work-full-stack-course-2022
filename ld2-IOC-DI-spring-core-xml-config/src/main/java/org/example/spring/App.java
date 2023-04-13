package org.example.spring;

import org.example.spring.service.PaymentGatewayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        PaymentGatewayService service = context.getBean("paymentGatewayService", PaymentGatewayService.class);
        service.pay();
    }
}
