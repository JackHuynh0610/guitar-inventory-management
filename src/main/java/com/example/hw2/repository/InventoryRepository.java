package com.example.hw2.repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.springframework.stereotype.Repository;
import com.example.hw2.model.Guitar;

@Repository
public class InventoryRepository {
    private List<Guitar> guitars = new ArrayList<>();
    
    public void addGuitar(Guitar guitar){
        guitars.add(guitar);
        // handle write to file
        writeToFile(guitar);
    }

    private void writeToFile(Guitar guitar) {
        //if file does not exist, create it
        if(!new File("guitars_database.txt").exists()){
            try {
                new File("guitars_database.txt").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
        for(Guitar guitar : this.guitars){
            if(guitar.getSerialNumber().equals(serialNumber)){
                return guitar;
            }
        }
        return null;
    }

    public List<Guitar> search(Guitar searchGuitar) {
        ArrayList<Guitar> matchingGuitars = new ArrayList<>();
        for (Guitar guitar : this.guitars) {
           if(guitar.equals(searchGuitar))
               matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }
}
