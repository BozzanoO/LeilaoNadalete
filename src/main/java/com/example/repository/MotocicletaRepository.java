package com.example.repository;

import com.example.entity.Veiculos.Motocicleta;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface MotocicletaRepository extends JpaRepository<Motocicleta, Long> {
}
