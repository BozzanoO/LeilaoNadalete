package com.example.entity.Veiculos;

import com.example.entity.Veiculo;
import com.example.entity.enums.TipoCombustivel;

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
public class Carro extends Veiculo {
    
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;
    
    private int numeroDePortas;
    private Long consumoCombustivel; // Em km/l
    private String potenciaMotor;
    private String tipoFreio;
    private boolean transmissaoManual;
    private boolean direcaoEletrica;
    private boolean temArCondicionado;
    private boolean temTetoSolar;
}
