package com.example.repository;

import com.example.entity.Dispositivos.Celular;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface CelularRepository extends JpaRepository<Celular, Long> {
}
