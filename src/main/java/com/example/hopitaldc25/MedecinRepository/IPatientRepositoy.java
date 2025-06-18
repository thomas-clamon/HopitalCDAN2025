package com.example.hopitaldc25.MedecinRepository;

import com.example.hopitaldc25.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepositoy extends JpaRepository<PatientEntity, Integer> {
}
