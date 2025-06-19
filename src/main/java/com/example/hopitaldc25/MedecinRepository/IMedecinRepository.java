package com.example.hopitaldc25.MedecinRepository;

import com.example.hopitaldc25.dtos.SpecialiteDto;
import com.example.hopitaldc25.dtos.StatMedecinDto;
import com.example.hopitaldc25.entities.MedecinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IMedecinRepository extends JpaRepository<MedecinEntity, Integer> {

    @Query(value = "select count(*) as 'nb' , specialite from Medecins\n" +
            "Group by specialite", nativeQuery = true)
    List<SpecialiteDto> getSpecialite();

    List<MedecinEntity> findAllBySpecialite(String specialite);

    @Query(value = "select TOP (?1) * from Medecins where specialite = ?2", nativeQuery = true)
    List<MedecinEntity>findTopNBySpecialite(Integer limit, String spe);

    @Query(value = "SELECT r1.nb, UPPER(CONCAT(Medecins.nom,' ',  Medecins.prenom)) as 'medecin' FROM (select count(*) as nb, id_medecin\n" +
            "from Rdvs\n" +
            "where CAST(date_debut_rdv AS DATE)  between ?1 and ?2\n" +
            "Group by id_medecin) r1, Medecins\n" +
            "Where r1.id_medecin = Medecins.ID", nativeQuery = true)
    List<StatMedecinDto> getSat(LocalDate debut, LocalDate fin);


}
