package com.example.hopitaldc25.services;

import com.example.hopitaldc25.MedecinRepository.IMedecinRepository;
import com.example.hopitaldc25.entities.MedecinEntity;
import com.example.hopitaldc25.enumerations.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MedecinService implements IMedecinService {

    @Autowired
    private IMedecinRepository medecinRepository;

    @Override
    public Integer ajouterMedecin(String nom, String prenom, LocalDate date_naissance, Specialite specialite) {
        // on cree une entity
        MedecinEntity entity = new MedecinEntity();
        entity.setNom(nom);
        entity.setPrenom(prenom);
        entity.setDate_naissance(date_naissance);
        entity.setSpecialite(specialite.name());

        // sauvegarde en base
        medecinRepository.saveAndFlush(entity);
        return entity.getID(); // renvoie l'ID
    }

    @Override

    public Integer getNbPatientMedecin(Integer id_medecin) {
        return null;
    }

    @Override
    public MedecinEntity exist(Integer id) {
        if (medecinRepository.existsById(id))
            return medecinRepository.findById(id).get();
        else
            return null;
    }
}
