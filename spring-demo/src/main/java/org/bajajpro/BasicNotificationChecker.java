package org.bajajpro;


import org.springframework.stereotype.Component;


@Component
public class BasicNotificationChecker implements NotificationChecker {
    @Override
    public boolean check(String msg) {
        System.out.println("basic checking done");
        if (msg != "") {
            return true;
        } else {
            return false;
        }
    }
}
