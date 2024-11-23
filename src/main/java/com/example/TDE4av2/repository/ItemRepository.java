package com.example.TDE4av2.repository;

import com.example.TDE4av2.model.Itens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Itens, Long> {
}
