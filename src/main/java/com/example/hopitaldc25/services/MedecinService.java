package com.example.hopitaldc25.services;

import com.example.hopitaldc25.MedecinRepository.IMedecinRepository;
import com.example.hopitaldc25.MedecinRepository.RdvRepository;
import com.example.hopitaldc25.dtos.RdvOutDto;
import com.example.hopitaldc25.entities.MedecinEntity;
import com.example.hopitaldc25.enumerations.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedecinService implements IMedecinService {

    @Autowired
    private IMedecinRepository medecinRepository;

    @Autowired
    private RdvService rdvService;

    @Autowired
    private RdvRepository rdvRepository;

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

    @Override
    public List<RdvOutDto> listeRdv(Integer id_medecin) {
        // on recupere la liste des rendez du medecin
        return medecinRepository.findById(id_medecin).get().getList_rdv().stream().map(entity -> rdvService.toOutDto(entity)).toList();
    }

    @Override
    public List<RdvOutDto> listRdvBetweenDates(Integer id_medecin, LocalDate start, LocalDate end) {
        return rdvRepository.getMedecinRdvByDate(id_medecin, start, end).stream().map(entity -> rdvService.toOutDto(entity)).toList();
    }
}
