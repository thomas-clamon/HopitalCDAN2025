package com.example.hopitaldc25.services;

import com.example.hopitaldc25.MedecinRepository.IPatientRepositoy;
import com.example.hopitaldc25.dtos.PatientInDto;
import com.example.hopitaldc25.entities.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService{

    @Autowired
    IPatientRepositoy repositoy;
    @Override
    public Integer ajouterPatient(PatientInDto dto) {
       PatientEntity entity =  dtoToEntiy(dto);
       repositoy.saveAndFlush(entity);
       return entity.getID();
    }

    private PatientEntity dtoToEntiy(PatientInDto dto){
        PatientEntity entity = new PatientEntity();
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setDate_naissance(dto.getDate_naissance());
        return entity;
    }
}
