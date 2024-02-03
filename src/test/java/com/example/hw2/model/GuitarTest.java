package com.example.hw2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class GuitarTest {
    @Test
    public void testGetSerialNumber() {
        
        Guitar guitar = new Guitar("12345", 1500.0, Guitar.Builder.MARTIN, "Stratocaster", Guitar.Type.ELECTRIC, Guitar.Wood.MAHOGANY, Guitar.Wood.MAPLE);
        assertEquals("12345", guitar.getSerialNumber());
    }

    @Test
    public void testGetPrice() {
        Guitar guitar = new Guitar("54321", 1200.0, Guitar.Builder.GIBSON, "Les Paul", Guitar.Type.ELECTRIC, Guitar.Wood.MAHOGANY, Guitar.Wood.MAPLE);
        assertEquals(1200.0, guitar.getPrice(), 0.001); // delta is used for double comparison
    }

    @Test
    public void testSetPrice() {
        Guitar guitar = new Guitar("98765", 1800.0, Guitar.Builder.GIBSON, "D-28", Guitar.Type.ACOUSTIC, Guitar.Wood.MAHOGANY, Guitar.Wood.MAPLE);
        guitar.setPrice(2000);
        assertEquals(2000.0, guitar.getPrice(), 0.001);
    }

    @Test
    public void testGetBuilder() {
        Guitar guitar = new Guitar("67890", 1000.0, Guitar.Builder.FENDER, "814ce", Guitar.Type.ACOUSTIC, Guitar.Wood.MAHOGANY, Guitar.Wood.MAPLE);
        assertEquals("Fender", guitar.getBuilder().toString());
    }

    @Test
    public void testGetModel() {
        Guitar guitar = new Guitar("67890", 1000.0, Guitar.Builder.FENDER, "SG", Guitar.Type.ACOUSTIC, Guitar.Wood.MAHOGANY, Guitar.Wood.MAPLE);
        assertEquals("SG", guitar.getModel());
    }

    @Test
    public void testGetType() {
        Guitar guitar = new Guitar("67890", 1000.0, Guitar.Builder.FENDER, "SG", Guitar.Type.ELECTRIC, Guitar.Wood.MAHOGANY, Guitar.Wood.MAPLE);
        assertEquals("Electric", guitar.getType().toString());
    }

    @Test
    public void testGetBackWood() {
        Guitar guitar = new Guitar("67890", 1000.0, Guitar.Builder.FENDER, "SG", Guitar.Type.ELECTRIC, Guitar.Wood.MAHOGANY, Guitar.Wood.MAPLE);
        assertEquals("Mahogany", guitar.getBackWood().toString());
    }

    @Test
    public void testGetTopWood() {
        Guitar guitar = new Guitar("67890", 1000.0, Guitar.Builder.FENDER, "SG", Guitar.Type.ELECTRIC, Guitar.Wood.MAPLE, Guitar.Wood.MAPLE);
        assertEquals("Maple", guitar.getTopWood().toString());
    }
}
