package org.bajajpro;

import org.springframework.stereotype.Component;


public interface NotificationChecker {

    boolean check(String msg);
}
