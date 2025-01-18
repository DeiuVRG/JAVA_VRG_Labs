package com.parcauto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Dezactivează CSRF pentru testare (opțional)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login", "/css/**", "/js/**").permitAll() // Permite accesul liber la login și resurse statice
                        .anyRequest().authenticated() // Toate celelalte cereri necesită autentificare
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Pagina de login personalizată
                        .defaultSuccessUrl("/home", true) // Redirect după login reușit
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true") // Redirect după logout
                        .permitAll()
                );

        return http.build();
    }
}
