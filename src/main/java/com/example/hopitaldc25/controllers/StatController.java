package com.example.hopitaldc25.controllers;

import com.example.hopitaldc25.services.IStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stat")
public class StatController {

    @Autowired
    private IStatService service;

    @GetMapping("specialite")
    public ResponseEntity specialite(){
        return new ResponseEntity(service.getSpecialite(), HttpStatusCode.valueOf(200));
    }

}
