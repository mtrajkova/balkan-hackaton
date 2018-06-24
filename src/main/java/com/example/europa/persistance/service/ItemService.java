package com.example.europa.persistance.service;

import com.example.europa.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> findAll();
    Optional<Item> findById(Long id);
    void save(Item item);
}
