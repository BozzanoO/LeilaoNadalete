package com.example.service;

import com.example.entity.Dispositivos.Notebook;
import com.example.repository.NotebookRepository;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class NotebookService {

    private final NotebookRepository notebookRepository;

    public NotebookService(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    @Transactional
    public Notebook salvar(Notebook notebook) {
        return notebookRepository.save(notebook);
    }

    public List<Notebook> listarTodos() {
        return notebookRepository.findAll();
    }

    public Optional<Notebook> buscarPorId(Long id) {
        return notebookRepository.findById(id);
    }

    @Transactional
    public Notebook atualizar(Long id, Notebook notebookAtualizado) {
        Notebook notebook = notebookRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Notebook não encontrado."));
        
        notebook.setTamanhoTela(notebookAtualizado.getTamanhoTela());
        notebook.setMemoriaRam(notebookAtualizado.getMemoriaRam());
        notebook.setArmazenamento(notebookAtualizado.getArmazenamento());
        notebook.setProcessador(notebookAtualizado.getProcessador());
        notebook.setTemPlacaDeVideoIntegrada(notebookAtualizado.isTemPlacaDeVideoIntegrada());
        notebook.setTemSSD(notebookAtualizado.isTemSSD());
        notebook.setTemPortaHDMI(notebookAtualizado.isTemPortaHDMI());
        notebook.setTemPortaVGA(notebookAtualizado.isTemPortaVGA());
        notebook.setTemPortaRJ45(notebookAtualizado.isTemPortaRJ45());
        notebook.setTemPortaP3(notebookAtualizado.isTemPortaP3());
        notebook.setTemPortaUSB(notebookAtualizado.isTemPortaUSB());
        
        return notebookRepository.save(notebook);
    }

    @Transactional
    public void deletar(Long id) {
        notebookRepository.deleteById(id);
    }
}
