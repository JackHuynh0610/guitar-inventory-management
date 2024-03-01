package com.example.hw2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hw2.model.Guitar;
import com.example.hw2.model.Guitar.Builder;
import com.example.hw2.model.Guitar.Wood;
import com.example.hw2.repository.InventoryRepository;
import com.example.hw2.model.Guitar.Type;

@RestController
@CrossOrigin
@RequestMapping("/inventory")
public class InventoryController {
    private InventoryRepository guitars;

    public InventoryController() {
        guitars = new InventoryRepository();
    }

    @PostMapping("/addGuitar")
    public boolean addGuitar(@RequestBody Guitar guitar) {
        guitars.addGuitar(guitar);
        return true;
    }

    @GetMapping("/findGuitar/{serialNumber}")
    public Guitar findGuitar(@PathVariable String serialNumber){
        return guitars.getGuitars(serialNumber);
    }

    @GetMapping("/search")
    public List<Guitar> search(@RequestParam(required = true) String serialNumber,
                               @RequestParam(required = true) double price,
                               @RequestParam(required = true) Builder builder,
                               @RequestParam(required = true) String model,
                               @RequestParam(required = true) Type type,
                               @RequestParam(required = true) Wood backWood,
                               @RequestParam(required = true) Wood topWood){
        Guitar searchGuitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        return guitars.search(searchGuitar);
    }

}
