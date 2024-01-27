package com.example.hw2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GuitarTest {
     @Test
    public void testGetSerialNumber() {
        Guitar guitar = new Guitar("12345", 1500.0, "Fender", "Stratocaster", "Electric", "Maple", "Alder");
        assertEquals("12345", guitar.getSerialNumber());
    }

    @Test
    public void testGetPrice() {
        Guitar guitar = new Guitar("54321", 1200.0, "Gibson", "Les Paul", "Electric", "Mahogany", "Maple");
        assertEquals(1200.0, guitar.getPrice(), 0.001); // delta is used for double comparison
    }

    @Test
    public void testSetPrice() {
        Guitar guitar = new Guitar("98765", 1800.0, "Martin", "D-28", "Acoustic", "Rosewood", "Spruce");
        guitar.setPrice(2000);
        assertEquals(2000.0, guitar.getPrice(), 0.001);
    }

    @Test
    public void testGetBuilder() {
        Guitar guitar = new Guitar("67890", 1000.0, "Taylor", "814ce", "Acoustic", "Rosewood", "Sitka");
        assertEquals("Taylor", guitar.getBuilder());
    }

    @Test
    public void testGetModel() {
        Guitar guitar = new Guitar("23456", 800.0, "Epiphone", "SG", "Electric", "Mahogany", "Mahogany");
        assertEquals("SG", guitar.getModel());
    }

    @Test
    public void testGetType() {
        Guitar guitar = new Guitar("34567", 700.0, "Ibanez", "RG550", "Electric", "Basswood", "Maple");
        assertEquals("Electric", guitar.getType());
    }

    @Test
    public void testGetBackWood() {
        Guitar guitar = new Guitar("45678", 900.0, "PRS", "Custom 24", "Electric", "Mahogany", "Maple");
        assertEquals("Mahogany", guitar.getBackWood());
    }

    @Test
    public void testGetTopWood() {
        Guitar guitar = new Guitar("78901", 1100.0, "Gretsch", "White Falcon", "Electric", "Maple", "Maple");
        assertEquals("Maple", guitar.getTopWood());
    }
}
