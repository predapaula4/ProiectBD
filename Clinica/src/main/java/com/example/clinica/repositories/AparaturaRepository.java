package com.example.clinica.repositories;

import com.example.clinica.entities.Aparatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AparaturaRepository extends JpaRepository<Aparatura, Long> {
}