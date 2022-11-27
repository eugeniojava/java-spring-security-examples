package com.eugeniojava.example1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfiguration {
    @Bean
    public UserDetailsService getUserDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();
        userDetailsService.createUser(
                User.withUsername("eugenio")
                        .password("123456")
                        .authorities("read")
                        .build()
        );
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
