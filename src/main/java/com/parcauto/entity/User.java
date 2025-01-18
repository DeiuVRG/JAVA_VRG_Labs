package com.parcauto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "utilizatori")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilizator") // Maparea corectă la coloana din tabel
    private Long id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "utilizator", unique = true) // Unicitate asigurată de tabel
    private String utilizator;

    @Column(name = "parola")
    private String parola;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol") // Maparea corectă pentru enum
    private Rol rol;

    // Getteri și setteri

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(String utilizator) {
        this.utilizator = utilizator;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
