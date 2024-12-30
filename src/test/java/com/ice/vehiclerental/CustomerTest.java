package com.ice.vehiclerental;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    @Test
    public void testAddRentalHistory() {
        Customer customer = new Customer("CU002", "Alice Smith");  // Changed customer ID and name
        customer.addRentalHistory("Rented Truck: Chevrolet for 5 days.");  // Changed vehicle and rental period
        assertTrue(customer.getRentalHistory().contains("Rented Truck: Chevrolet for 5 days."));
    }

    @Test
    public void testLoyaltyPoints() {
        Customer customer = new Customer("CU002", "Alice Smith");  // Changed customer ID and name
        customer.addLoyaltyPoints(15);  // Changed loyalty points
        assertEquals(15, customer.getLoyaltyPoints());  // Updated the expected loyalty points
    }
}
