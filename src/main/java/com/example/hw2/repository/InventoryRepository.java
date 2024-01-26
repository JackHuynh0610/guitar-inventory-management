package com.example.hw2.repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.hw2.model.Guitar;

public class InventoryRepository {
    private List<Guitar> guitars;
    
    
    public void addGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood){
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        guitars.add(guitar);
        // handle write to file
        writeToFile(guitar);
    }

    private void writeToFile(Guitar guitar) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("guitars_database.txt", true))) {
            // Append the guitar information to the file
            writer.write(guitar.getSerialNumber() + "," +
                        guitar.getPrice() + "," +
                        guitar.getBuilder() + "," +
                        guitar.getModel() + "," +
                        guitar.getType() + "," +
                        guitar.getBackWood() + "," +
                        guitar.getTopWood());
            writer.newLine(); // Add a new line for the next entry
        } catch (IOException e) {
            // Handle the exception, e.g., print an error message or log it
            e.printStackTrace();
        }
    }

    public Guitar getGuitars(String serialNumber) {
        for(Guitar guitar : guitars){
            if(guitar.getSerialNumber().equals(serialNumber)){
                return guitar;
            }
        }
        return null;
    }

    public List<Guitar> search(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood){
        ArrayList<Guitar> guitars = new ArrayList<>();
        for(Guitar guitar : this.guitars){
            if(serialNumber != null && !serialNumber.equals("") && !guitar.getSerialNumber().equals(serialNumber)){
                continue;
            }
            if(price != 0.0 && guitar.getPrice() != price){
                continue;
            }
            if(builder != null && !builder.equals("") && !guitar.getBuilder().equals(builder)){
                continue;
            }
            if(model != null && !model.equals("") && !guitar.getModel().equals(model)){
                continue;
            }
            if(type != null && !type.equals("") && !guitar.getType().equals(type)){
                continue;
            }
            if(backWood != null && !backWood.equals("") && !guitar.getBackWood().equals(backWood)){
                continue;
            }
            if(topWood != null && !topWood.equals("") && !guitar.getTopWood().equals(topWood)){
                continue;
            }
            guitars.add(guitar);
        }
        return guitars;
    }
}
