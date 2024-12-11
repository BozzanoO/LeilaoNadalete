package com.example.repository;

import com.example.entity.Veiculos.Caminhao;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {
}
