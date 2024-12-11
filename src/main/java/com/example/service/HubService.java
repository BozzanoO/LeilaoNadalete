package com.example.service;

import com.example.entity.Dispositivos.Hub;
import com.example.repository.HubRepository;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class HubService {

    private final HubRepository hubRepository;

    public HubService(HubRepository hubRepository) {
        this.hubRepository = hubRepository;
    }

    @Transactional
    public Hub salvar(Hub hub) {
        return hubRepository.save(hub);
    }

    public List<Hub> listarTodos() {
        return hubRepository.findAll();
    }

    public Optional<Hub> buscarPorId(Long id) {
        return hubRepository.findById(id);
    }

    @Transactional
    public Hub atualizar(Long id, Hub hubAtualizado) {
        Hub hub = hubRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Hub não encontrado."));
        
        hub.setNumeroDePortas(hubAtualizado.getNumeroDePortas());
        hub.setTamanhoDoDispositivo(hubAtualizado.getTamanhoDoDispositivo());
        
        return hubRepository.save(hub);
    }

    @Transactional
    public void deletar(Long id) {
        hubRepository.deleteById(id);
    }
}
