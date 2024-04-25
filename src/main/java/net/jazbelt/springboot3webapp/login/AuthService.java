package net.jazbelt.springboot3webapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean authenticate(String user, String pass) {
        return user.equals("jdoe") && pass.equals("1234");
    }
}
