package com.example.repository;

import com.example.entity.Veiculo;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
