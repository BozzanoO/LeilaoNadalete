package com.example.entity.Dispositivos;

import com.example.entity.Dispositivo;
import com.example.entity.enums.EntradaDeVideo;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Monitor extends Dispositivo {
    
    @Enumerated(EnumType.STRING)
    private EntradaDeVideo entradaDeVideo;

    private String resolucao;
    private int polegadas;
    private boolean temAudioEmbutido;
}
