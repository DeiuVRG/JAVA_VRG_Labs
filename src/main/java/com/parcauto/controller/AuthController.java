package com.parcauto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Thymeleaf va căuta "login.html" în /templates
    }

    @GetMapping("/logout-success")
    public String logout() {
        return "redirect:/login?logout=true";
    }
}
