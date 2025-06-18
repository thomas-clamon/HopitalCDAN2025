package com.example.hopitaldc25.controllers;

import com.example.hopitaldc25.dtos.MedecinInDto;
import com.example.hopitaldc25.enumerations.Specialite;
import com.example.hopitaldc25.services.IMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Medecin")
public class MedecinController {

    @Autowired
    private IMedecinService medecinService;
    @PostMapping("add")
    ResponseEntity ajouterMedecin(  @RequestBody MedecinInDto dto){

        // Verifier que les entré sont bonne
        Specialite specialite;
        //verification de l'enumeration specialite
        try {
            specialite = Specialite.valueOf(dto.getSpecialite());
        }
        catch (IllegalArgumentException illegalArgumentException){
            return new ResponseEntity("la specialité n'est pas bonne ", HttpStatusCode.valueOf(400));
        }

        Integer ID =medecinService.ajouterMedecin(dto.getNom(), dto.getPrenom(), dto.getDate_naissance(), specialite);
        return new ResponseEntity<>(ID, HttpStatusCode.valueOf(200));

    }

}
