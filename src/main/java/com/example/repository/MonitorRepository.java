package com.example.repository;

import com.example.entity.Dispositivos.Monitor;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
