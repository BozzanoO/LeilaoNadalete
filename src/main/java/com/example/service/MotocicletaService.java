package com.example.service;

import com.example.entity.Veiculos.Motocicleta;
import com.example.repository.MotocicletaRepository;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Singleton
@AllArgsConstructor
public class MotocicletaService {

    private final MotocicletaRepository motocicletaRepository;

    @Transactional
    public Motocicleta salvar(Motocicleta motocicleta) {
        return motocicletaRepository.save(motocicleta);
    }

    public List<Motocicleta> listarTodos() {
        return motocicletaRepository.findAll();
    }

    public Optional<Motocicleta> buscarPorId(Long id) {
        return motocicletaRepository.findById(id);
    }

    @Transactional
    public Motocicleta atualizar(Long id, Motocicleta motocicletaAtualizada) {
        Motocicleta motocicleta = motocicletaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Motocicleta não encontrada."));

        // Atualizando os atributos da entidade Motocicleta
        motocicleta.setModelo(motocicletaAtualizada.getModelo());
        motocicleta.setMarca(motocicletaAtualizada.getMarca());
        motocicleta.setPlaca(motocicletaAtualizada.getPlaca());
        motocicleta.setAno(motocicletaAtualizada.getAno());
        motocicleta.setCapacidadeTanque(motocicletaAtualizada.getCapacidadeTanque());
        motocicleta.setAlturaAssento(motocicletaAtualizada.getAlturaAssento());
        motocicleta.setCilindrada(motocicletaAtualizada.getCilindrada());
        motocicleta.setTipoFreio(motocicletaAtualizada.getTipoFreio());
        motocicleta.setTemBagageiro(motocicletaAtualizada.isTemBagageiro());
        motocicleta.setTransmissaoManual(motocicletaAtualizada.isTransmissaoManual());
        motocicleta.setTipoCombustivel(motocicletaAtualizada.getTipoCombustivel());
        motocicleta.setCategoriaVeiculo(motocicletaAtualizada.getCategoriaVeiculo());
        motocicleta.setValorInicial(motocicletaAtualizada.getValorInicial());
        motocicleta.setLeilao(motocicletaAtualizada.getLeilao());

        return motocicletaRepository.save(motocicleta);
    }

    @Transactional
    public void deletar(Long id) {
        motocicletaRepository.deleteById(id);
    }
}
