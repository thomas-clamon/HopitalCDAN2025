package com.example.hopitaldc25.MedecinRepository;

import com.example.hopitaldc25.entities.RdvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RdvRepository extends JpaRepository<RdvEntity, Integer> {

    @Query(value = "select * from Rdvs where id_medecin = ?1 and date_debut_rdv between ?2 and ?3", nativeQuery = true)
    List<RdvEntity> getMedecinRdvByDate(Integer id_medecin, LocalDate start, LocalDate fin);
}
