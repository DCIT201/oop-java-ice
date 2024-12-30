package com.ice.vehiclerental;

import com.ice.vehiclerental.vehicles.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    public void testCalculateRentalCost() {
        Car car = new Car("C002", "Honda", 60);  // Changed vehicle ID and model
        assertEquals(180, car.calculateRentalCost(3));  // Updated expected rental cost (60 * 3 = 180)
    }

    @Test
    public void testRentAndReturn() {
        Car car = new Car("C002", "Honda", 60);  // Changed vehicle ID and model
        Customer customer = new Customer("CU002", "Alice Smith");  // Changed customer ID and name
        car.rent(customer, 3);
        assertFalse(car.isAvailable());
        car.returnVehicle();
        assertTrue(car.isAvailable());
    }
}
