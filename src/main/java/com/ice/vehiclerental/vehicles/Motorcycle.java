package com.ice.vehiclerental.vehicles;

import com.ice.vehiclerental.Customer;
import com.ice.vehiclerental.transactions.Rentable;

public class Motorcycle extends Vehicle implements Rentable {

    public Motorcycle(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 0.85; // Give a 15% discount for motorcycles (pay 85% of the base rate)
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable(); // To check if the motorcycle is available for rental
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.addRentalHistory("Rented Motorcycle: " + getModel() + " for " + days + " days.");
        } //To add motorcycle to customer's rent history
    }

    @Override
    public void returnVehicle() {
        setAvailable(true); // To tell the motorcycle is available after being returned
    }
}
