package org.bajajpro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


//        BasicNotificationChecker basicNotificationChecker = new BasicNotificationChecker();
//        AdvancedNotificationChecker advancedNotificationChecker = new AdvancedNotificationChecker();
//        NotificationClient notificationClient = new NotificationClient(advancedNotificationChecker);
//        notificationClient.send();


//        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("spring-config.xml");
//
//        NotificationClient notificationClient=context.getBean("notificationClient",NotificationClient.class);
//
//        notificationClient.send();


        // For Checking Scope
//        AdvancedNotificationChecker advancedNotificationChecker=context.getBean("advancedNotificationChecker",AdvancedNotificationChecker.class);
//        AdvancedNotificationChecker advancedNotificationChecker1=context.getBean("advancedNotificationChecker",AdvancedNotificationChecker.class);
      //  advancedNotificationChecker.check("Hi");

//        System.out.println(advancedNotificationChecker);
//        System.out.println(advancedNotificationChecker1);


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
//        NotificationClient notificationClient = context.getBean("notificationClient" , NotificationClient.class);
//        notificationClient.send();

        DemoClient demoClient=context.getBean("demoClient", DemoClient.class);
        demoClient.send();


    }
}