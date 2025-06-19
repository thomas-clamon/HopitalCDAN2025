package com.example.hopitaldc25.services;

import com.example.hopitaldc25.MedecinRepository.IMedecinRepository;
import com.example.hopitaldc25.dtos.SpecialiteDto;
import com.example.hopitaldc25.dtos.StatMedecinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatService implements  IStatService{
    @Autowired
    private IMedecinRepository medecinRepository;

    @Override
    public List<SpecialiteDto> getSpecialite() {
        return medecinRepository.getSpecialite();
    }

    @Override
    public List<StatMedecinDto> getRdvByMonth(LocalDate debut, LocalDate fin) {
        return medecinRepository.getSat(debut, fin);
    }
}
