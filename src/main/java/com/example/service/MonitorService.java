package com.example.service;

import com.example.entity.Dispositivos.Monitor;
import com.example.repository.MonitorRepository;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @Transactional
    public Monitor salvar(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    public List<Monitor> listarTodos() {
        return monitorRepository.findAll();
    }

    public Optional<Monitor> buscarPorId(Long id) {
        return monitorRepository.findById(id);
    }

    @Transactional
    public Monitor atualizar(Long id, Monitor monitorAtualizado) {
        Monitor monitor = monitorRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Monitor não encontrado."));
        
        monitor.setEntradaDeVideo(monitorAtualizado.getEntradaDeVideo());
        monitor.setResolucao(monitorAtualizado.getResolucao());
        monitor.setPolegadas(monitorAtualizado.getPolegadas());
        monitor.setTemAudioEmbutido(monitorAtualizado.isTemAudioEmbutido());
        
        return monitorRepository.save(monitor);
    }

    @Transactional
    public void deletar(Long id) {
        monitorRepository.deleteById(id);
    }
}
