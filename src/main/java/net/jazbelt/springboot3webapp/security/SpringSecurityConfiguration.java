package net.jazbelt.springboot3webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SuppressWarnings("removal")
@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetails() {
        UserDetails user = User.builder()
                .passwordEncoder(x -> bcryptPasswordEncoder().encode(x))
                .username("john")
                .password("1234")
                .roles("USER", "ADMIN")
                .build();

        UserDetails user2 = User.builder()
                .passwordEncoder(x -> bcryptPasswordEncoder().encode(x))
                .username("jack")
                .password("foo")
                .roles("USER")
                .build();

        UserDetails user3 = User.builder()
                .passwordEncoder(x -> bcryptPasswordEncoder().encode(x))
                .username("jane")
                .password("bar")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user, user2, user3);
    }

    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        httpSecurity.formLogin(Customizer.withDefaults());

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

        return httpSecurity.build();
    }
}
