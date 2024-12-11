package com.example.service;

import com.example.entity.Veiculos.Caminhao;
import com.example.repository.CaminhaoRepository;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Singleton
@AllArgsConstructor
public class CaminhaoService {

    private final CaminhaoRepository caminhaoRepository;

    @Transactional
    public Caminhao salvar(Caminhao caminhao) {
        return caminhaoRepository.save(caminhao);
    }

    public List<Caminhao> listarTodos() {
        return caminhaoRepository.findAll();
    }

    public Optional<Caminhao> buscarPorId(Long id) {
        return caminhaoRepository.findById(id);
    }

    @Transactional
    public Caminhao atualizar(Long id, Caminhao caminhaoAtualizado) {
        Caminhao caminhao = caminhaoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Caminhão não encontrado."));
        caminhao.setModelo(caminhaoAtualizado.getModelo());
        caminhao.setMarca(caminhaoAtualizado.getMarca());
        caminhao.setPlaca(caminhaoAtualizado.getPlaca());
        caminhao.setAno(caminhaoAtualizado.getAno());
        caminhao.setQuantidadeEixos(caminhaoAtualizado.getQuantidadeEixos());
        caminhao.setCapacidadeCarga(caminhaoAtualizado.getCapacidadeCarga());
        caminhao.setComprimento(caminhaoAtualizado.getComprimento());
        caminhao.setTemCarroceria(caminhaoAtualizado.isTemCarroceria());
        caminhao.setTipoCombustivel(caminhaoAtualizado.getTipoCombustivel());
        caminhao.setTipoCarreta(caminhaoAtualizado.getTipoCarreta());
        caminhao.setValorInicial(caminhaoAtualizado.getValorInicial());
        caminhao.setLeilao(caminhaoAtualizado.getLeilao());

        return caminhaoRepository.save(caminhao);
    }

    @Transactional
    public void deletar(Long id) {
        caminhaoRepository.deleteById(id);
    }
}
