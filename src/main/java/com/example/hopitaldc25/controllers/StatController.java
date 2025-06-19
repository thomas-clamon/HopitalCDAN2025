package com.example.hopitaldc25.controllers;

import com.example.hopitaldc25.services.IStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("stat")
public class StatController {

    @Autowired
    private IStatService service;

    @GetMapping("specialite")
    public ResponseEntity specialite(){
        return new ResponseEntity(service.getSpecialite(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("count_rdv")
    public ResponseEntity getAllRdv(@RequestParam("start") LocalDate debut, @RequestParam("end") LocalDate fin ){

        //verifie que la date de debut est bien avant la date de fin
        if (debut.isAfter(fin))
            return new ResponseEntity<>("mauvaise date", HttpStatusCode.valueOf(400));

        return new ResponseEntity<>(service.getRdvByMonth(debut, fin) , HttpStatusCode.valueOf(200));
    }



}
