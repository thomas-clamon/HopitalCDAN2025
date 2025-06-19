package com.example.hopitaldc25.MedecinRepository;

import com.example.hopitaldc25.dtos.SpecialiteDto;
import com.example.hopitaldc25.entities.MedecinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMedecinRepository extends JpaRepository<MedecinEntity, Integer> {

    @Query(value = "select count(*) as 'nb' , specialite from Medecins\n" +
            "Group by specialite", nativeQuery = true)
    List<SpecialiteDto> getSpecialite();
}
