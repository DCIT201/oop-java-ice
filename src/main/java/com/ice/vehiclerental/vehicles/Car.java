package com.ice.vehiclerental.vehicles;

import com.ice.vehiclerental.Customer;
import com.ice.vehiclerental.transactions.Rentable;

public class Car extends Vehicle implements Rentable {

    public Car(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }
    // Calculating the rental cost for the given number of days based on the base rental rate
    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days;
    }
    // To check if the car is available for rent
    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.addRentalHistory("Rented Car: " + getModel() + " for " + days + " days.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);// To tell the car is available after being returned
    }
}
