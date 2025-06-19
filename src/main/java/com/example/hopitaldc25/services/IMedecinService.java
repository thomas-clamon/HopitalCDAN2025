package com.example.hopitaldc25.services;

import com.example.hopitaldc25.dtos.RdvOutDto;
import com.example.hopitaldc25.entities.MedecinEntity;
import com.example.hopitaldc25.enumerations.Specialite;

import java.time.LocalDate;
import java.util.List;

public interface IMedecinService {

    Integer ajouterMedecin (String nom, String prenom, LocalDate date_naissance, Specialite specialite);
    Integer getNbPatientMedecin(Integer id_medecin);

    /**
     * Renvoi l'entity si le medecin existe null si il n'existe pas
     * @param id
     * @return
     */
    MedecinEntity exist(Integer id);

    List<RdvOutDto> listeRdv(Integer id_medecin);
    
    List<RdvOutDto> listRdvBetweenDates(Integer id_medecin, LocalDate start, LocalDate end);
}
