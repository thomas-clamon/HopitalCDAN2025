package com.example.hopitaldc25.dtos;

import java.time.LocalDateTime;

public class RdvOutDto {

    private String medecin; // nom prenom
    private String patient; // nom prenom

    private LocalDateTime date_debut;

    private Long duree ; // min

    public String getMedecin() {
        return medecin;
    }

    public void setMedecin(String medecin) {
        this.medecin = medecin;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public Long getDuree() {
        return duree;
    }

    public void setDuree(Long duree) {
        this.duree = duree;
    }

    public LocalDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }
}
