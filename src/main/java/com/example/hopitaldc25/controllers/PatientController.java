package com.example.hopitaldc25.controllers;

import com.example.hopitaldc25.dtos.PatientInDto;
import com.example.hopitaldc25.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Patient")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @PostMapping("add")
    public ResponseEntity ajouter(@RequestBody PatientInDto dto){

        return new ResponseEntity(patientService.ajouterPatient(dto),
                HttpStatusCode.valueOf(200));
    }
}
