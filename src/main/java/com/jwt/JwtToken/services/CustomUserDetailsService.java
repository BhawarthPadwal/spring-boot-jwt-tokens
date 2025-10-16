package com.jwt.JwtToken.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Map<String, String> USERS = Map.of(
            "bhawarth", "{noop}password123"
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!USERS.containsKey(username)) throw new UsernameNotFoundException("User not found: " + username);

        return User.withUsername(username)
                .password(USERS.get(username))
                .roles("USER")
                .build();
    }
}
