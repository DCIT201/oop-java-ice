package com.ice.vehiclerental.vehicles;

import com.ice.vehiclerental.Customer;
import com.ice.vehiclerental.transactions.Rentable;

public class Truck extends Vehicle implements Rentable {

    public Truck(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 1.3; // Add a 30% surcharge for trucks
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable(); // Check if the truck is available for rental
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false); // telling the truck is unavailable
            customer.addRentalHistory("Rented Truck: " + getModel() + " for " + days + " days.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true); // the truck is available after being returned
    }
}
