package com.ice.vehiclerental.vehicles;

import java.util.ArrayList;
import java.util.List;
import com.ice.vehiclerental.Rateable;

public abstract class Vehicle implements Rateable {

    private final String vehicleId;
    private final String model;
    private final double baseRentalRate;
    private boolean isAvailable;
    private final List<Integer> ratings;

    public Vehicle(String vehicleId, String model, double baseRentalRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
        this.ratings = new ArrayList<>();
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public abstract double calculateRentalCost(int days);

    public abstract boolean isAvailableForRental();

    @Override
    public void addRating(int rating) {
        ratings.add(rating);
    }

    @Override
    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        for (int rating : ratings) {
            total += rating;
        }
        return total / (double) ratings.size();
    }
}