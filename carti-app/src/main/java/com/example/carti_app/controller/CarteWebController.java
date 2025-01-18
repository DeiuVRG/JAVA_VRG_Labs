package com.example.carti_app.controller;

import com.example.carti_app.model.Carte;
import com.example.carti_app.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarteWebController {

    @Autowired
    private CarteRepository carteRepository;

    @GetMapping("/lista-carti")
    public String getCarti(Model model) {
        model.addAttribute("carti", carteRepository.findAll());
        model.addAttribute("mesaj", "Lista cartilor preluate prin repository");
        return "carti";
    }

    @PostMapping("/operatii")
    public String handleOperatii(
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) String titlu,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) String adauga,
            @RequestParam(required = false) String modifica,
            @RequestParam(required = false) String sterge,
            @RequestParam(required = false) String filtreaza,
            Model model) {

        String mesaj = "";

        if (adauga != null) {
            if (isbn.isEmpty() || titlu.isEmpty() || autor.isEmpty()) {
                mesaj = "Adaugarea nu se realizează dacă nu completaţi toate caracteristicile!";
            } else {
                carteRepository.save(   new Carte(isbn, titlu, autor));
                mesaj = "Adaugare realizata cu succes!";
            }
        } else if (modifica != null) {
            Carte carte = carteRepository.findById(isbn).orElse(null);
            if (carte == null) {
                mesaj = "Nu se găsește nici o carte cu isbn-ul introdus.";
            } else {
                carte.setTitlu(titlu);
                carte.setAutor(autor);
                carteRepository.save(carte);
                mesaj = "Cartea cu ISBN-ul " + isbn + " a fost modificată!";
            }
        } else if (sterge != null) {
            if (isbn.isEmpty()) {
                mesaj = "Vă rugăm să introduceți un ISBN pentru ștergere!";
            } else {
                carteRepository.deleteById(isbn);
                mesaj = "Cartea cu ISBN-ul " + isbn + " a fost ștearsă!";
            }
        } else if (filtreaza != null) {
            List<Carte> carti;
            if (autor.isEmpty()) {
                carti = carteRepository.findAll();
                mesaj = "Toate cărțile au fost afișate.";
            } else {
                carti = carteRepository.findByAutor(autor);
                mesaj = "Cărțile următoare aparțin autorului " + autor + ".";
            }
            model.addAttribute("carti", carti);
            model.addAttribute("mesaj", mesaj);
            return "carti";
        }

        model.addAttribute("carti", carteRepository.findAll());
        model.addAttribute("mesaj", mesaj);
        return "carti";
    }
}
