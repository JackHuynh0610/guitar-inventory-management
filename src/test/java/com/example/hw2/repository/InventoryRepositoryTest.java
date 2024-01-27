package com.example.hw2.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.hw2.model.Guitar;

public class InventoryRepositoryTest {
    @Test
    void testAddGuitar() {
        InventoryRepository inventoryRepository = new InventoryRepository();
        Guitar guitar = new Guitar("12345", 1500.0, "Fender", "Stratocaster", "Electric", "Maple", "Alder");
        inventoryRepository.addGuitar(guitar);
        assertEquals("12345", guitar.getSerialNumber());
        assertEquals(1500.0, guitar.getPrice(), 0.001);
        assertEquals("Fender", guitar.getBuilder());
        assertEquals("Stratocaster", guitar.getModel());
        assertEquals("Electric", guitar.getType());
        assertEquals("Maple", guitar.getBackWood());
        assertEquals("Alder", guitar.getTopWood());

        Guitar guitar2 = new Guitar("12346", 1500.0, "Fender", "Stratocaster", "Electric", "Maple", "Alder");
        inventoryRepository.addGuitar(guitar2);
        assertEquals("12346", guitar2.getSerialNumber());
        assertEquals(1500.0, guitar2.getPrice(), 0.001);
        assertEquals("Fender", guitar2.getBuilder());
        assertEquals("Stratocaster", guitar2.getModel());
        assertEquals("Electric", guitar2.getType());
        assertEquals("Maple", guitar2.getBackWood());
        assertEquals("Alder", guitar2.getTopWood());

    }

    @Test
    void testGetGuitars() {
        // Arrange
        InventoryRepository inventory = new InventoryRepository();
        Guitar guitar1 = new Guitar("12345", 999.99, "Fender", "Stratocaster", "Electric", "Maple", "Alder");
        Guitar guitar2 = new Guitar("54321", 799.95, "Gibson", "Les Paul", "Electric", "Mahogany", "Maple");
        inventory.addGuitar(guitar1);
        inventory.addGuitar(guitar2);

        // Act
        Guitar foundGuitar = inventory.getGuitars("12345");

        // Assert
        assertNotNull(foundGuitar);
        assertEquals("12345", foundGuitar.getSerialNumber());
        assertEquals(999.99, foundGuitar.getPrice(), 0.001); // Using a small tolerance for floating-point comparison
        assertEquals("Fender", foundGuitar.getBuilder());
        assertEquals("Stratocaster", foundGuitar.getModel());
        assertEquals("Electric", foundGuitar.getType());
        assertEquals("Maple", foundGuitar.getBackWood());
        assertEquals("Alder", foundGuitar.getTopWood());

         // Arrange
        InventoryRepository inventory2 = new InventoryRepository();
        Guitar guitar3 = new Guitar("12345", 999.99, "Fender", "Stratocaster", "Electric", "Maple", "Alder");
        Guitar guitar4 = new Guitar("54321", 799.95, "Gibson", "Les Paul", "Electric", "Mahogany", "Maple");
        inventory.addGuitar(guitar3);
        inventory.addGuitar(guitar4);

        // Act
        Guitar foundGuitar2 = inventory2.getGuitars("99999"); // Nonexistent serial number

        // Assert
        assertNull(foundGuitar2);
    }

    @Test
    void testSearch() {
        // Arrange
        InventoryRepository inventory = new InventoryRepository();
        Guitar guitar1 = new Guitar("12345", 999.99, "Fender", "Stratocaster", "Electric", "Maple", "Alder");
        Guitar guitar2 = new Guitar("54321", 799.95, "Gibson", "Les Paul", "Electric", "Mahogany", "Maple");
        inventory.addGuitar(guitar1);
        inventory.addGuitar(guitar2);

        // Criteria for search
        Guitar searchCriteria = new Guitar(null, 0.0, "Fender", "Stratocaster", "Electric", null, null);

        // Act
        List<Guitar> foundGuitars = inventory.search(searchCriteria);
        // Assert
        assertEquals(1, foundGuitars.size());
        assertEquals(guitar1, foundGuitars.get(0));
    }
}
