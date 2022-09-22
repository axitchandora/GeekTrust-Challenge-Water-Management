package com.geektrust.backend.entites;

public class Bill{
   private final Apartment apartment;
    private Double totalAmount;

    public Bill(Apartment apartment, Double totalAmount) {
        this.apartment = apartment;
        this.totalAmount = totalAmount;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }
}
