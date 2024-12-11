package com.example.service;

import com.example.entity.Veiculos.Carro;
import com.example.repository.CarroRepository;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Singleton
@AllArgsConstructor
public class CarroService {

    private final CarroRepository carroRepository;

    @Transactional
    public Carro salvar(Carro carro) {
        return carroRepository.save(carro);
    }

    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    public Optional<Carro> buscarPorId(Long id) {
        return carroRepository.findById(id);
    }

    @Transactional
    public Carro atualizar(Long id, Carro carroAtualizado) {
        Carro carro = carroRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Carro não encontrado."));
        carro.setModelo(carroAtualizado.getModelo());
        carro.setMarca(carroAtualizado.getMarca());
        carro.setPlaca(carroAtualizado.getPlaca());
        carro.setAno(carroAtualizado.getAno());
        carro.setTipoCombustivel(carroAtualizado.getTipoCombustivel());
        carro.setNumeroDePortas(carroAtualizado.getNumeroDePortas());
        carro.setConsumoCombustivel(carroAtualizado.getConsumoCombustivel());
        carro.setPotenciaMotor(carroAtualizado.getPotenciaMotor());
        carro.setTipoFreio(carroAtualizado.getTipoFreio());
        carro.setTransmissaoManual(carroAtualizado.isTransmissaoManual());
        carro.setDirecaoEletrica(carroAtualizado.isDirecaoEletrica());
        carro.setTemArCondicionado(carroAtualizado.isTemArCondicionado());
        carro.setTemTetoSolar(carroAtualizado.isTemTetoSolar());
        carro.setValorInicial(carroAtualizado.getValorInicial());
        carro.setLeilao(carroAtualizado.getLeilao());

        return carroRepository.save(carro);
    }

    @Transactional
    public void deletar(Long id) {
        carroRepository.deleteById(id);
    }
}
