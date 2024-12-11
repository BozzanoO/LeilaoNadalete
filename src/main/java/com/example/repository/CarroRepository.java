package com.example.repository;

import com.example.entity.Veiculos.Carro;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
