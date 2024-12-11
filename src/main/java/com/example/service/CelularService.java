package com.example.service;

import com.example.entity.Dispositivos.Celular;
import com.example.repository.CelularRepository;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class CelularService {

    private final CelularRepository celularRepository;

    public CelularService(CelularRepository celularRepository) {
        this.celularRepository = celularRepository;
    }

    @Transactional
    public Celular salvar(Celular celular) {
        return celularRepository.save(celular);
    }

    public List<Celular> listarTodos() {
        return celularRepository.findAll();
    }

    public Optional<Celular> buscarPorId(Long id) {
        return celularRepository.findById(id);
    }

    @Transactional
    public Celular atualizar(Long id, Celular celularAtualizado) {
        Celular celular = celularRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Celular não encontrado."));
        
        celular.setTamanhoTela(celularAtualizado.getTamanhoTela());
        celular.setMemoriaRam(celularAtualizado.getMemoriaRam());
        celular.setArmazenamento(celularAtualizado.getArmazenamento());
        celular.setProcessador(celularAtualizado.getProcessador());
        celular.setEntradaDeCarregamento(celularAtualizado.getEntradaDeCarregamento());
        celular.setTem5G(celularAtualizado.isTem5G());
        
        return celularRepository.save(celular);
    }

    @Transactional
    public void deletar(Long id) {
        celularRepository.deleteById(id);
    }
}
