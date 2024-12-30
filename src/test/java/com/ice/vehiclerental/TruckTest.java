package com.ice.vehiclerental;

import com.ice.vehiclerental.vehicles.Truck;
import com.ice.vehiclerental.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TruckTest {

    @Test
    public void testCalculateRentalCost() {
        Truck truck = new Truck("T002", "Chevrolet", 80);  // Changed ID and model
        assertEquals(312, truck.calculateRentalCost(3)); // 30% surcharge (80 * 3 * 1.3 = 336)
    }

    @Test
    public void testRentAndReturn() {
        Truck truck = new Truck("T002", "Chevrolet", 80);  // Changed ID and model
        Customer customer = new Customer("CU002", "Alice Smith");  // Changed customer ID and name
        truck.rent(customer, 3);
        assertFalse(truck.isAvailable());
        truck.returnVehicle();
        assertTrue(truck.isAvailable());
    }
}
