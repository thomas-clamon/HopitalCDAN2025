package com.example.hopitaldc25.services;

import com.example.hopitaldc25.dtos.RdvInDto;
import com.example.hopitaldc25.dtos.RdvOutDto;
import com.example.hopitaldc25.entities.RdvEntity;

public interface IRdvService {

    RdvEntity ajouterRdv(RdvInDto dto);

    RdvOutDto get (Integer id);

    Boolean exist(Integer id);
}
