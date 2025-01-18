package com.parcauto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "jocdesah10"; // Aici parola dorita
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Parola criptată: " + encodedPassword);
    }
}
