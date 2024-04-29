package net.jazbelt.springboot3webapp.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class AppUtils {

    public static String getLoggedUser() {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }
}
