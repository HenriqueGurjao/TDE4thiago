package com.example.TDE4av2.service;

import com.example.TDE4av2.model.Itens;
import com.example.TDE4av2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItensService {

    @Autowired
    private ItemRepository itemRepository;

    // Listar todos os itens
    public List<Itens> getAllItems() {
        return itemRepository.findAll();
    }

    // Buscar item por ID
    public Optional<Itens> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // Adicionar novo item
    public Itens createItem(Itens item) {
        return itemRepository.save(item);
    }

    // Atualizar item existente
    public Itens updateItem(Long id, Itens updatedItem) {
        Optional<Itens> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Itens item = existingItem.get();
            item.setNome(updatedItem.getNome());
            item.setNome(updatedItem.getPreco());
            // Atualize outros campos conforme necessário
            return itemRepository.save(item);
        } else {
            throw new RuntimeException("Item com ID " + id + " não encontrado.");
        }
    }

    // Deletar item
    public void deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else {
            throw new RuntimeException("Item com ID " + id + " não encontrado.");
        }
    }
}
