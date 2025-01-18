package com.parcauto.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal User user, Model model) {
        String rol = user.getAuthorities().iterator().next().getAuthority();

        if (rol.equals("ROLE_USER")) {
            return "redirect:/user/home";
        } else if (rol.equals("ROLE_EDITOR")) {
            return "redirect:/editor/home";
        }

        return "redirect:/login";
    }
}
