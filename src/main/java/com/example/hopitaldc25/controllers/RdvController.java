package com.example.hopitaldc25.controllers;

import com.example.hopitaldc25.dtos.RdvInDto;
import com.example.hopitaldc25.services.IRdvService;
import com.example.hopitaldc25.services.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rdv")
public class RdvController {

    @Autowired
    private IRdvService rdvService;

    @PostMapping("add")
    public ResponseEntity ajouterRdv(@RequestBody RdvInDto dto){

        // on verifie que le medecin existe

        // on verifie que le patient existe

        // pas de rdv dans le passe

        // pas debut rendez vous aprés la fin

        // on appelle notre service pour ajouter un rendez
        return new ResponseEntity(rdvService.ajouterRdv(dto).getID(), HttpStatusCode.valueOf(200));

    }


}
