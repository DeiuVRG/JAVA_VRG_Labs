package com.parcauto.controller;

import com.parcauto.entity.Masina;
import com.parcauto.service.MasinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private MasinaService masinaService;

    @GetMapping("/user/home")
    public String home(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String culoare,
            @RequestParam(required = false) String tipCombustibil,
            Model model
    ) {
        List<Masina> masini = masinaService.filtreazaMasini(marca, culoare, tipCombustibil);
        model.addAttribute("masini", masini);
        return "user-home"; // Thymeleaf va căuta "user-home.html"
    }
}
