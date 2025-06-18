package com.example.hopitaldc25.services;

import com.example.hopitaldc25.entities.MedecinEntity;
import com.example.hopitaldc25.enumerations.Specialite;

import java.time.LocalDate;

public interface IMedecinService {

    Integer ajouterMedecin (String nom, String prenom, LocalDate date_naissance, Specialite specialite);
    Integer getNbPatientMedecin(Integer id_medecin);

    /**
     * Renvoi l'entity si le medecin existe null si il n'existe pas
     * @param id
     * @return
     */
    MedecinEntity exist(Integer id);
}
