package com.example.service;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import com.example.entity.Dispositivo;
import com.example.repository.DispositivoRepository;

@Singleton
@AllArgsConstructor
public class DispositivoService {

    private final DispositivoRepository dispositivoRepository;

    @Transactional
    public Dispositivo salvar(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    public List<Dispositivo> listarTodos() {
        return dispositivoRepository.findAll();
    }

    public Optional<Dispositivo> buscarPorId(Long id) {
        return dispositivoRepository.findById(id);
    }

    @Transactional
    public Dispositivo atualizar(Long id, Dispositivo dispositivoAtualizado) {
        Dispositivo dispositivo = dispositivoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Dispositivo não encontrado."));
        dispositivo.setMarca(dispositivoAtualizado.getMarca());
        dispositivo.setModelo(dispositivoAtualizado.getModelo());
        dispositivo.setCor(dispositivoAtualizado.getCor());
        dispositivo.setValorInicial(dispositivoAtualizado.getValorInicial());
        dispositivo.setLeilao(dispositivoAtualizado.getLeilao());
        return dispositivoRepository.save(dispositivo);
    }

    @Transactional
    public void deletar(Long id) {
        dispositivoRepository.deleteById(id);
    }
}
