package com.example.entity.Dispositivos;

import com.example.entity.Dispositivo;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
public class Hub extends Dispositivo {
    private int numeroDePortas;
    private int tamanhoDoDispositivo;
}