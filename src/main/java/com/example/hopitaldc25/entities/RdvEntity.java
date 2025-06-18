package com.example.hopitaldc25.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Rdvs")
public class RdvEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

     @Column(name = "date_debut_rdv")
    private LocalDateTime date_debut;


    @Column(name = "date_fin_rdv")
    private LocalDateTime date_fin;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medecin")
    private MedecinEntity medecinEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient")
    private PatientEntity patientEntity;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public LocalDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDateTime getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public MedecinEntity getMedecinEntity() {
        return medecinEntity;
    }

    public void setMedecinEntity(MedecinEntity medecinEntity) {
        this.medecinEntity = medecinEntity;
    }

    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    public void setPatientEntity(PatientEntity patientEntity) {
        this.patientEntity = patientEntity;
    }
}
