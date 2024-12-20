package com.example.repository;

import com.example.entity.Dispositivos.Notebook;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
}
