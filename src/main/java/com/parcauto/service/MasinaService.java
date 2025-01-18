package com.parcauto.service;

import com.parcauto.entity.Masina;
import com.parcauto.repository.MasinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasinaService {

    @Autowired
    private MasinaRepository masinaRepository;

    public List<Masina> filtreazaMasini(String marca, String culoare, String tipCombustibil) {
        if (marca == null && culoare == null && tipCombustibil == null) {
            return masinaRepository.findAll();
        }
        return masinaRepository.findByMarcaAndCuloareAndTipCombustibil(marca, culoare, tipCombustibil);
    }

    public List<Masina> toateMasinile() {
        return masinaRepository.findAll();
    }

    public void adaugaMasina(Masina masina) {
        masinaRepository.save(masina);
    }

    public void modificaMasina(String nrInmatriculare, Masina masinaNoua) {
        Masina masina = masinaRepository.findById(nrInmatriculare).orElseThrow();
        if (masinaNoua.getMarca() != null) masina.setMarca(masinaNoua.getMarca());
        if (masinaNoua.getModel() != null) masina.setModel(masinaNoua.getModel());
        // Modifică și celelalte câmpuri similare...
        masinaRepository.save(masina);
    }

    public void stergeMasina(String nrInmatriculare) {
        masinaRepository.deleteById(nrInmatriculare);
    }
}
