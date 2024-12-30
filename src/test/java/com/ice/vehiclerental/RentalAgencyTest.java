package com.ice.vehiclerental;

import com.ice.vehiclerental.exceptions.InvalidRentalPeriodException;
import com.ice.vehiclerental.exceptions.VehicleNotAvailableException;
import com.ice.vehiclerental.vehicles.Car;
import com.ice.vehiclerental.vehicles.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RentalAgencyTest {
    @Test
    public void testRentVehicle() throws VehicleNotAvailableException, InvalidRentalPeriodException {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C002", "Honda", 60);  // Changed vehicle ID and model
        agency.addVehicle(car);
        Vehicle rentedCar = agency.rentVehicle("C002", 5);  // Changed rental period to 5
        assertNotNull(rentedCar);
        assertFalse(rentedCar.isAvailable());
    }

    @Test
    public void testRentVehicleNotAvailable() {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C002", "Honda", 60);  // Changed vehicle ID and model
        agency.addVehicle(car);
        assertThrows(VehicleNotAvailableException.class, () -> {
            agency.rentVehicle("C003", 4);  // Changed vehicle ID to an unexistent one
        });
    }

    @Test
    public void testInvalidRentalPeriod() {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("C002", "Honda", 60);  // Changed vehicle ID and model
        agency.addVehicle(car);
        assertThrows(InvalidRentalPeriodException.class, () -> {
            agency.rentVehicle("C002", -1);  // Changed rental period to an invalid value (-1)
        });
    }
}

