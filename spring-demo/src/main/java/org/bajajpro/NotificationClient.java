package org.bajajpro;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationClient {
    @Autowired
    @Qualifier("basicNotificationChecker")
    NotificationChecker notificationChecker;
//    public void setNotificationChecker(NotificationChecker notificationChecker) {
//        this.notificationChecker = notificationChecker;
//    }



//    @Autowired
//    public NotificationClient(NotificationChecker notificationChecker){
//        this.notificationChecker=notificationChecker;
//    }

    public void send(){
        String msg="Hello World";
        if (notificationChecker.check(msg)){
            System.out.println("Notification sent");
        }else {
            System.out.println("Validation failed");
        }
    }

}
