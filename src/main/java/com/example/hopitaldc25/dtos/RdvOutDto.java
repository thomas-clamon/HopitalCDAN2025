package com.example.hopitaldc25.dtos;

public class RdvOutDto {

    private String medecin; // nom prenom
    private String patient; // nom prenom

    private Integer duree ; // min

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

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }
}
