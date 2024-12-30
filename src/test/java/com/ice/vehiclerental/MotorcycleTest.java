package com.ice.vehiclerental;

import com.ice.vehiclerental.vehicles.Motorcycle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotorcycleTest {
    @Test
    public void
    testCalculateRentalCost() {
        Motorcycle motorcycle = new Motorcycle("F221", "Royal", 30);
        assertEquals(76.5, motorcycle.calculateRentalCost(3)); // 10% discount
    }

    @Test
    public void testRentAndReturn() {
        Motorcycle motorcycle = new Motorcycle("F221", "Royal", 60);
        Customer customer = new Customer("CU076", "Kojo Asamoah");
        motorcycle.rent(customer, 5);
        assertFalse(motorcycle.isAvailable());
        motorcycle.returnVehicle();
        assertTrue(motorcycle.isAvailable());
    }
}