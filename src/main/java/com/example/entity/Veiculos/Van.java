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
public class Van extends Veiculo {
    private int capacidadePassageiros;
    private Long capacidadeCarga;
    private boolean temArCondicionado;
    private boolean temBagageiroSuperior;

    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;
}
