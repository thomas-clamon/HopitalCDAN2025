package com.example.hopitaldc25.services;

import com.example.hopitaldc25.MedecinRepository.IMedecinRepository;
import com.example.hopitaldc25.MedecinRepository.IPatientRepositoy;
import com.example.hopitaldc25.MedecinRepository.RdvRepository;
import com.example.hopitaldc25.dtos.RdvInDto;
import com.example.hopitaldc25.entities.MedecinEntity;
import com.example.hopitaldc25.entities.PatientEntity;
import com.example.hopitaldc25.entities.RdvEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
