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
public class Notebook extends Dispositivo {
    private int tamanhoTela;
    private int memoriaRam;
    private int armazenamento;
    private String processador;
    private boolean temPlacaDeVideoIntegrada;
    private boolean temSSD;
    private boolean temPortaHDMI;
    private boolean temPortaVGA;
    private boolean temPortaRJ45;
    private boolean temPortaP3;
    private boolean temPortaUSB;
}