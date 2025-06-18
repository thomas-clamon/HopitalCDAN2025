package com.example.hopitaldc25.controllers;

import com.example.hopitaldc25.dtos.RdvInDto;
import com.example.hopitaldc25.entities.RdvEntity;
import com.example.hopitaldc25.services.IRdvService;
import com.example.hopitaldc25.services.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("get/{id}")
    public ResponseEntity get (@PathVariable String id){
                Integer ID;
                try{
                    ID = Integer.parseInt(id);
                }
                catch (Exception e){
                    return new ResponseEntity<>("ID incorrect", HttpStatusCode.valueOf(400));
        }
        // on verifie que le rendez vous existe
        if (!rdvService.exist(ID))
            return new ResponseEntity("le rendez vous n'existe pas", HttpStatusCode.valueOf(204));

        return new ResponseEntity<>(rdvService.get(ID),HttpStatusCode.valueOf(200));
    }


}
