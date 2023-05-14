package com.example.clinica.repositories;

import com.example.clinica.entities.Pacient;
import com.example.clinica.entities.Procedura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProceduraRepository extends JpaRepository<Procedura, Long> {
    List<Procedura> findByAparaturaId(Long idAparatura);
}