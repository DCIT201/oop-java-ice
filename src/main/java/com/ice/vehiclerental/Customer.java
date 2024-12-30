package com.ice.vehiclerental;

public class Customer implements LoyaltyProgram {
    private final String customerId;
    private final String name;
    private String rentalHistory;
    private int loyaltyPoints;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = "";
        this.loyaltyPoints = 0;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }

    public String getRentalHistory() {
        return this.rentalHistory;
    }

    public void addRentalHistory(String rental) {
        this.rentalHistory = this.rentalHistory + rental + "\n";
    }
    @Override
    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }
    @Override
    public int getLoyaltyPoints() {
        return this.loyaltyPoints;
    }
}

