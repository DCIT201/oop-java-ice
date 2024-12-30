package com.ice.vehiclerental.transactions;

import com.ice.vehiclerental.Customer;

public interface Rentable {
    void rent(Customer var1, int var2);

    void returnVehicle();
}
