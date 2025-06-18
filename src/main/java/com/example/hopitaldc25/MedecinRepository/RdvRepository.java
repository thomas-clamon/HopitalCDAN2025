package com.example.hopitaldc25.MedecinRepository;

import com.example.hopitaldc25.entities.RdvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RdvRepository extends JpaRepository<RdvEntity, Integer> {
}
