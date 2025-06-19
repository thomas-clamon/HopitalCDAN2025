package com.example.hopitaldc25.services;

import com.example.hopitaldc25.dtos.SpecialiteDto;
import com.example.hopitaldc25.dtos.StatMedecinDto;

import java.time.LocalDate;
import java.util.List;

public interface IStatService {

    List<SpecialiteDto> getSpecialite();

    List<StatMedecinDto> getRdvByMonth(LocalDate debut, LocalDate fin);
}
