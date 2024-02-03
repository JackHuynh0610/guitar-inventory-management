package com.example.hw2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hw2.model.Guitar;
import com.example.hw2.model.Guitar.Builder;
import com.example.hw2.model.Guitar.Wood;
import com.example.hw2.model.Guitar.Type;

@RestController
public class InventoryController {
    private List<Guitar> guitars;

    public InventoryController() {
        guitars = new ArrayList<Guitar>();
    }

    @PostMapping("/addGuitar")
    public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood){
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        guitars.add(guitar);
    }

    @GetMapping("/findGuitar/{serialNumber}")
    public Guitar findGuitar(String serialNumber){
        try {
            for(Guitar guitar : guitars){
                if(guitar.getSerialNumber().equals(serialNumber)){
                    return guitar;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @GetMapping("/search")
    public List<Guitar> search(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood,Wood topWood){
        ArrayList<Guitar> guitars = new ArrayList<>();
        for(Guitar guitar : this.guitars){
            if(serialNumber != null && !serialNumber.equals("") && !guitar.getSerialNumber().equals(serialNumber)){
                continue;
            }
            if(price != 0.0 && guitar.getPrice() != price){
                continue;
            }
            if(builder != null && !builder.equals(null) && !guitar.getBuilder().equals(builder)){
                continue;
            }
            if(model != null && !model.equals(null) && !guitar.getModel().equals(model)){
                continue;
            }
            if(type != null && !type.equals(null) && !guitar.getType().equals(type)){
                continue;
            }
            if(backWood != null && !backWood.equals(null) && !guitar.getBackWood().equals(backWood)){
                continue;
            }
            if(topWood != null && !topWood.equals(null) && !guitar.getTopWood().equals(topWood)){
                continue;
            }
            guitars.add(guitar);
        }
        return guitars;
    }

}
