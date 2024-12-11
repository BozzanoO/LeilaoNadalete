package com.example.entity.Veiculos;

import com.example.entity.Veiculo;
import com.example.entity.enums.CategoriaVeicular;
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
public class Motocicleta extends Veiculo {
    
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;
    
    @Enumerated(EnumType.STRING)
    private CategoriaVeicular categoriaVeiculo;
    
    private Long capacidadeTanque; // Em litros
    private Long alturaAssento; // Em centímetros
    private String cilindrada;
    private String tipoFreio;
    private boolean temBagageiro;
    private boolean transmissaoManual;
}

