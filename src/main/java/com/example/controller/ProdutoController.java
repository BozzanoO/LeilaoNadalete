package com.example.controller;

import com.example.entity.Produto;
import com.example.entity.Dispositivos.Celular;
import com.example.entity.Dispositivos.Hub;
import com.example.entity.Dispositivos.Monitor;
import com.example.entity.Dispositivos.Notebook;
import com.example.entity.Veiculos.Caminhao;
import com.example.entity.Veiculos.Carro;
import com.example.entity.Veiculos.Motocicleta;
import com.example.entity.Veiculos.Van;
import com.example.repository.ProdutoRepository;
import com.example.service.CaminhaoService;
import com.example.service.CarroService;
import com.example.service.CelularService;
import com.example.service.HubService;
import com.example.service.MonitorService;
import com.example.service.MotocicletaService;
import com.example.service.NotebookService;
import com.example.service.VanService;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final CarroService carroService;
    private final MotocicletaService motocicletaService;
    private final CaminhaoService caminhaoService;
    private final VanService vanService;
    private final NotebookService notebookService;
    private final HubService hubService;
    private final MonitorService monitorService;
    private final CelularService celularService;

    @Post
    @Transactional
    public HttpResponse<Produto> cadastrar(@Body @Valid Produto produto) {
        return HttpResponse.created(produtoRepository.save(produto));
    }

    @Post("/carro")
    @Transactional
    public HttpResponse<Carro> cadastrarCarro(@Body @Valid Carro carro) {
        return HttpResponse.created(carroService.salvar(carro));
    }

    @Post("/motocicleta")
    @Transactional
    public HttpResponse<Motocicleta> cadastrarMotocicleta(@Body @Valid Motocicleta motocicleta) {
        return HttpResponse.created(motocicletaService.salvar(motocicleta));
    }

    @Post("/van")
    @Transactional
    public HttpResponse<Van> cadastrarVan(@Body @Valid Van van) {
        return HttpResponse.created(vanService.salvar(van));
    }

    @Post("/caminhao")
    @Transactional
    public HttpResponse<Caminhao> cadastrarCaminhao(@Body @Valid Caminhao caminhao) {
        return HttpResponse.created(caminhaoService.salvar(caminhao));
    }

    @Post("/hub")
    @Transactional
    public HttpResponse<Hub> cadastrarHub(@Body @Valid Hub hub) {
        return HttpResponse.created(hubService.salvar(hub));
    }

    @Post("/monitor")
    @Transactional
    public HttpResponse<Monitor> cadastrarMonitor(@Body @Valid Monitor monitor) {
        return HttpResponse.created(monitorService.salvar(monitor));
    }

    @Post("/notebook")
    @Transactional
    public HttpResponse<Notebook> cadastrarNotebook(@Body @Valid Notebook notebook) {
        return HttpResponse.created(notebookService.salvar(notebook));
    }

    @Post("/celular")
    @Transactional
    public HttpResponse<Celular> cadastrarCelular(@Body @Valid Celular celular) {
        return HttpResponse.created(celularService.salvar(celular));
    }

    @Get("/{id}")
    public Produto detalhar(@PathVariable Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }

    @Delete("/{id}")
    @Transactional
    public HttpResponse<Void> deletar(@PathVariable Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        
        if (produto instanceof Carro) carroService.deletar(id);
        else if (produto instanceof Motocicleta) motocicletaService.deletar(id);
        else if (produto instanceof Van) vanService.deletar(id);
        else if (produto instanceof Caminhao) caminhaoService.deletar(id);
        else if (produto instanceof Hub) hubService.deletar(id);
        else if (produto instanceof Monitor) monitorService.deletar(id);
        else if (produto instanceof Notebook) notebookService.deletar(id);
        else if (produto instanceof Celular) celularService.deletar(id);
        else throw new IllegalArgumentException("Tipo de produto desconhecido");

        produtoRepository.deleteById(id);
        return HttpResponse.noContent();
    }
}
