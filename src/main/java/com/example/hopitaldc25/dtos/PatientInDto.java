package com.example.hopitaldc25.dtos;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class PatientInDto {

    private String nom;
    private String prenom;

    private LocalDate date_naissance;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }
}
