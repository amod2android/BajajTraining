package org.bajajpro;


import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AdvancedNotificationChecker implements NotificationChecker{

    @Override
    public boolean check(String msg) {
        System.out.println("Advanced checking done");
        if (msg != "" && msg.length()>10) {
            return true;
        } else {
            return false;
        }
    }
}
