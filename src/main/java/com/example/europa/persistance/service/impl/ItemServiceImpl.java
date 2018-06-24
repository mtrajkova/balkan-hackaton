package com.example.europa.persistance.service.impl;

import com.example.europa.model.Item;
import com.example.europa.persistance.repository.ItemRepository;
import com.example.europa.persistance.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Override
    public List<Item> findAll() {
        return this.itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return this.itemRepository.findById(id);
    }

    @Override
    public void save(Item item) {
        this.itemRepository.save(item);
    }
}
