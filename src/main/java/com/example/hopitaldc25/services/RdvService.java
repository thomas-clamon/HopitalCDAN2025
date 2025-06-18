package com.example.hopitaldc25.services;

import com.example.hopitaldc25.MedecinRepository.IMedecinRepository;
import com.example.hopitaldc25.MedecinRepository.IPatientRepositoy;
import com.example.hopitaldc25.MedecinRepository.RdvRepository;
import com.example.hopitaldc25.dtos.RdvInDto;
import com.example.hopitaldc25.dtos.RdvOutDto;
import com.example.hopitaldc25.entities.MedecinEntity;
import com.example.hopitaldc25.entities.PatientEntity;
import com.example.hopitaldc25.entities.RdvEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Period;

@Service
public class RdvService implements IRdvService{

    @Autowired
    RdvRepository rdvRepository;

    @Autowired
    IPatientRepositoy patientRepositoy;

    @Autowired
    IMedecinRepository medecinRepository;

    @Override
    public RdvEntity ajouterRdv(RdvInDto dto) {
        RdvEntity entity = new RdvEntity();

        // on recupere le medecin
        MedecinEntity medecinEntity = medecinRepository.findById(dto.getId_medecin()).get();

        // on recupere le patient
        PatientEntity patientEntity = patientRepositoy.findById(dto.getId_patient()).get();

        entity.setMedecinEntity(medecinEntity);
        entity.setPatientEntity(patientEntity);

        entity.setDate_debut(dto.getDate_debut());
        entity.setDate_fin(dto.getDate_fin());

        // on sauvegarde
        rdvRepository.saveAndFlush(entity);
        return entity;
    }

    @Override
    public RdvOutDto get(Integer id) {
        return toOutDto(rdvRepository.findById(id).get());
    }

    @Override
    public Boolean exist(Integer id) {
        return rdvRepository.existsById(id);
    }

    public RdvOutDto toOutDto(RdvEntity entity){
        RdvOutDto result = new RdvOutDto();
        result.setMedecin(entity.getMedecinEntity().getPrenom() + " " + entity.getMedecinEntity().getNom());
        result.setPatient(entity.getPatientEntity().getPrenom() + " " + entity.getPatientEntity().getNom());

        // caluler la durée
        Long  minute = Duration.between(entity.getDate_debut(), entity.getDate_fin()).toMinutes();
        result.setDuree(minute);

        result.setDate_debut(entity.getDate_debut());
        return result;
    }

}
