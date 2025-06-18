package com.example.hopitaldc25.MedecinRepository;

import com.example.hopitaldc25.entities.MedecinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedecinRepository extends JpaRepository<MedecinEntity, Integer> {
}
