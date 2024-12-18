package com.example.repository;

import com.example.entity.Veiculos.Van;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface VanRepository extends JpaRepository<Van, Long> {
}
