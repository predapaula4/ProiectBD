package com.example.clinica.repositories;

import com.example.clinica.entities.Programare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ProgramareRepository extends JpaRepository<Programare, Long> {
    List<Programare> findByDataConsultatie(LocalDate data);
    List<Programare> findByOraConsultatiei(LocalTime ora);
}