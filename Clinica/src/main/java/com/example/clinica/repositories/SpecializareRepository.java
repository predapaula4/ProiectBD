package com.example.clinica.repositories;

import com.example.clinica.entities.Specializare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializareRepository extends JpaRepository<Specializare, Long> {
}