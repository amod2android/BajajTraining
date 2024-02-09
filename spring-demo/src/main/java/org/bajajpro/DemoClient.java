package org.bajajpro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DemoClient {

    @Autowired
     NotificationChecker notificationChecker;
    public void send(){
        String msg="Hello World";
        if (notificationChecker.check(msg)){
            System.out.println("Notification sent");
        }else {
            System.out.println("Validation failed");
        }
    }

}
