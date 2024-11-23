package com.example.TDE4av2.controller;


import com.example.TDE4av2.model.Itens;
import com.example.TDE4av2.service.ItensService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens")
@Tag(name = "Itens", description = "Endpoints para gerenciar itens")
public class ItensController {

    @Autowired
    private ItensService itensService;

    @GetMapping
    @Operation(summary = "Listar todos os itens", description = "Retorna uma lista de itens")
    public List<Itens> getAllItens() {
        return itensService.getAllItems();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item por ID", description = "Retorna um item pelo ID")
    public Itens getItemById(@PathVariable Long id) {
        return itensService.getItemById(id).orElseThrow(() ->
                new RuntimeException("Item com ID " + id + " não encontrado."));
    }

    @PostMapping
    @Operation(summary = "Adicionar novo item", description = "Adiciona um novo item à lista")
    public Itens createItem(@RequestBody Itens item) {
        return itensService.createItem(item);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item", description = "Atualiza os detalhes de um item existente")
    public Itens updateItem(@PathVariable Long id, @RequestBody Itens updatedItem) {
        return itensService.updateItem(id, updatedItem);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar item", description = "Remove um item da lista pelo ID")
    public void deleteItem(@PathVariable Long id) {
        itensService.deleteItem(id);
    }
}
