package com.parcauto.repository;

import com.parcauto.entity.Masina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasinaRepository extends JpaRepository<Masina, String> {
    List<Masina> findByMarcaAndCuloareAndTipCombustibil(String marca, String culoare, String tipCombustibil);
}
