package com.parcauto.controller;

import com.parcauto.entity.Masina;
import com.parcauto.service.MasinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EditorController {

    @Autowired
    private MasinaService masinaService;

    @GetMapping("/editor/home")
    public String home(Model model) {
        model.addAttribute("masini", masinaService.toateMasinile());
        return "editor-home";
    }

    @PostMapping("/editor/adauga")
    public String adaugaMasina(Masina masina) {
        masinaService.adaugaMasina(masina);
        return "redirect:/editor/home";
    }

    @PostMapping("/editor/modifica")
    public String modificaMasina(@RequestParam String nrInmatriculare, Masina masina) {
        masinaService.modificaMasina(nrInmatriculare, masina);
        return "redirect:/editor/home";
    }

    @PostMapping("/editor/sterge")
    public String stergeMasina(@RequestParam String nrInmatriculare) {
        masinaService.stergeMasina(nrInmatriculare);
        return "redirect:/editor/home";
    }
}
