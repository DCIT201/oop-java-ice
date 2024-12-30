package com.ice.vehiclerental;

import com.ice.vehiclerental.exceptions.InvalidRentalPeriodException;
import com.ice.vehiclerental.exceptions.VehicleNotAvailableException;
import com.ice.vehiclerental.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> vehicleFleet = new ArrayList();

    public RentalAgency() {
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicleFleet.add(vehicle);
    }

    public Vehicle rentVehicle(String vehicleId, int days) throws VehicleNotAvailableException, InvalidRentalPeriodException {
        if (days <= 0) {
            throw new InvalidRentalPeriodException("Rental period must be greater than zero.");
        } else {
            for(Vehicle vehicle : this.vehicleFleet) {
                if (vehicle.getVehicleId().equals(vehicleId) && vehicle.isAvailableForRental()) {
                    vehicle.setAvailable(false);
                    return vehicle;
                }
            }

            throw new VehicleNotAvailableException("Vehicle with ID " + vehicleId + " is not available for rental.");
        }
    }

    public void returnVehicle(Vehicle vehicle) {
        vehicle.setAvailable(true);
    }

    public void generateReport() {
    }
}
