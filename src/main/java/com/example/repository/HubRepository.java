package com.example.repository;

import com.example.entity.Dispositivos.Hub;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface HubRepository extends JpaRepository<Hub, Long> {
}
