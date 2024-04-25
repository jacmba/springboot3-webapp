package net.jazbelt.springboot3webapp.login;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

record User(String name, String password) {}

@Service
public class AuthService {

    private final List<User> users;

    public AuthService() {
        users = List.of(
                new User("john", "1234"),
                new User("jack", "foo"),
                new User("jane", "bar")
        );
    }

    public boolean authenticate(String user, String pass) {
        Optional<User> result = users.stream()
                .filter(u ->
                        u.name().equals(user) && u.password().equals(pass))
                .findFirst();

        return result.isPresent();
    }
}
