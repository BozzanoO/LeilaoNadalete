package com.example.service;

import com.example.entity.Veiculos.Van;
import com.example.repository.VanRepository;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Singleton
@AllArgsConstructor
public class VanService {

    private final VanRepository vanRepository;

    @Transactional
    public Van salvar(Van van) {
        return vanRepository.save(van);
    }

    public List<Van> listarTodos() {
        return vanRepository.findAll();
    }

    public Optional<Van> buscarPorId(Long id) {
        return vanRepository.findById(id);
    }

    @Transactional
    public Van atualizar(Long id, Van vanAtualizada) {
        Van van = vanRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Van não encontrada."));
        van.setModelo(vanAtualizada.getModelo());
        van.setMarca(vanAtualizada.getMarca());
        van.setPlaca(vanAtualizada.getPlaca());
        van.setAno(vanAtualizada.getAno());
        van.setCapacidadePassageiros(vanAtualizada.getCapacidadePassageiros());
        van.setCapacidadeCarga(vanAtualizada.getCapacidadeCarga());
        van.setTemArCondicionado(vanAtualizada.isTemArCondicionado());
        van.setTemBagageiroSuperior(vanAtualizada.isTemBagageiroSuperior());
        van.setTipoCombustivel(vanAtualizada.getTipoCombustivel());
        van.setValorInicial(vanAtualizada.getValorInicial());
        van.setLeilao(vanAtualizada.getLeilao());

        return vanRepository.save(van);
    }

    @Transactional
    public void deletar(Long id) {
        vanRepository.deleteById(id);
    }
}
