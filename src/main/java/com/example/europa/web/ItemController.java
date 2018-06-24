package com.example.europa.web;

import com.example.europa.model.Item;
import com.example.europa.persistance.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/all")
    public List<Item> findAll(){
        return this.itemService.findAll();
    }
}
