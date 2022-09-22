package com.geektrust.backend.services;

import com.geektrust.backend.dto.GeneratedBillDto;

public interface IApartmentBillService {
    public void allotWaterForApartment(Integer typeOfApartment, String corporationIsToBoreWellRatio);
    public void addGuestToApartment(Integer noOfGuests);

    public GeneratedBillDto calculateBillForApartment();
}
