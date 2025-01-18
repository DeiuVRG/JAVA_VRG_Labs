package com.parcauto.service;

import com.parcauto.entity.User;
import com.parcauto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUtilizator(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUtilizator())
                .password(user.getParola())
                .roles(user.getRol().name().replace("ROLE_", ""))// Elimină prefixul "ROLE_" pentru Spring Security
                .build();
    }
}
