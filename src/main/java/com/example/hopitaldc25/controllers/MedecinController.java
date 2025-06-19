package com.example.hopitaldc25.controllers;

import com.example.hopitaldc25.dtos.MedecinInDto;
import com.example.hopitaldc25.enumerations.Specialite;
import com.example.hopitaldc25.services.IMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("Medecin")
public class MedecinController {

    @Autowired
    private IMedecinService medecinService;

    @PostMapping("add")
    ResponseEntity ajouterMedecin(@RequestBody MedecinInDto dto) {

        // Verifier que les entré sont bonne
        Specialite specialite;
        //verification de l'enumeration specialite
        try {
            specialite = Specialite.valueOf(dto.getSpecialite());
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity("la specialité n'est pas bonne ", HttpStatusCode.valueOf(400));
        }

        Integer ID = medecinService.ajouterMedecin(dto.getNom(), dto.getPrenom(), dto.getDate_naissance(), specialite);
        return new ResponseEntity<>(ID, HttpStatusCode.valueOf(200));

    }

    @GetMapping("getrdv/{id}")
    public ResponseEntity getRdv(@PathVariable String id) {
        // verifier que le medecin existe
        Integer ID;
        try {
            ID = Integer.parseInt(id);
        } catch (Exception e) {
            return new ResponseEntity<>("ID incorrect", HttpStatusCode.valueOf(400));
        }
            // verifie que le medecin existe
            if (null == medecinService.exist(ID)) {
                return new ResponseEntity("le medecin n'existe pas", HttpStatusCode.valueOf(204));
            }
            return new ResponseEntity(medecinService.listeRdv(ID), HttpStatusCode.valueOf(200));


        }
        @GetMapping("rdv/{id}")
        public ResponseEntity getRdvDate (@PathVariable String id, @RequestParam("start")LocalDate debut, @RequestParam("end") LocalDate fin) {

            // verifier que le medecin existe
            Integer ID;
            try {
                ID = Integer.parseInt(id);
            } catch (Exception e) {
                return new ResponseEntity<>("ID incorrect", HttpStatusCode.valueOf(400));
            }
            // verifie que le medecin existe
            if (null == medecinService.exist(ID)) {
                return new ResponseEntity("le medecin n'existe pas", HttpStatusCode.valueOf(204));
            }

            // on verifie que la date fin n'est pas superieur a la date de deubut
            if (debut.isAfter(fin)) {
                return new ResponseEntity("Erreur de date", HttpStatusCode.valueOf(400));
            }
            return new ResponseEntity(medecinService.listRdvBetweenDates(ID, debut, fin), HttpStatusCode.valueOf(200));
        }
        @GetMapping("all/{specialite}")
        public ResponseEntity getAllBySpecialite(@PathVariable("specialite") String spe, @RequestParam(required = false) Integer limit){

        // on controle que la specialite fait partie de l'enumeration
        String specialite = spe.toUpperCase();
        try {
            Specialite.valueOf(specialite);
        }catch (IllegalArgumentException e){
            return new ResponseEntity("la specialite n'existe pas", HttpStatusCode.valueOf(400));
        }
        if(null != limit)
            return new ResponseEntity(medecinService.getMedecinBySpecialité(limit, specialite), HttpStatusCode.valueOf(200));
        return new ResponseEntity(medecinService.getMedecinBySpecialité(specialite), HttpStatusCode.valueOf(200));

        }

    }