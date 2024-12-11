package com.example.entity.Veiculos;

import com.example.entity.Veiculo;
import com.example.entity.enums.TipoCarreta;
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
public class Caminhao extends Veiculo {
    private int quantidadeEixos;
    private Long capacidadeCarga;
    private Long comprimento;
    private boolean temCarroceria;

    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Enumerated(EnumType.STRING)
    private TipoCarreta tipoCarreta;

}
