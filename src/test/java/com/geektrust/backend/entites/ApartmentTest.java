package com.geektrust.backend.entites;

import com.geektrust.backend.constants.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ApartmentTest")
public class ApartmentTest {

    @Test
    @DisplayName("checkIfApartment is assigning correct water allocation for Two Bhk")
    public void testCheckingAllotWaterToCorporateAndBoreWellForTwoBhk(){
        int apartmentType=Constants.TWO_BHK;
        String corporationIsToBoreWellRatio="3:7";
        Apartment apartment=new Apartment(apartmentType,corporationIsToBoreWellRatio);
        assertEquals(900,apartment.getMonthlyWaterAllocatedForTenants());
        assertEquals(270,apartment.getAllocatedWaterForCorporationWater());
        assertEquals(630,apartment.getAllocatedWaterForBoreWellWater());
    }
    @Test
    @DisplayName("should create a default Apartment")
    public void shouldCreateADefaultApartment() {
        Apartment apartment = new Apartment();
        assertNotNull(apartment);
    }

    @Test
    @DisplayName("checkIfApartment is assigning correct water allocation for Three Bhk")
    public void testCheckingAllotWaterToCorporateAndBoreWellForThreeBhk(){
        int apartmentType=Constants.THREE_BHK;
        String corporationIsToBoreWellRatio="3:7";
        Apartment apartment=new Apartment(apartmentType,corporationIsToBoreWellRatio);
        assertEquals(1500,apartment.getMonthlyWaterAllocatedForTenants());
        assertEquals(450,apartment.getAllocatedWaterForCorporationWater());
        assertEquals(1050,apartment.getAllocatedWaterForBoreWellWater());
    }

    @Test
    @DisplayName("addGuestToApartment is assigning correct no of guest and total water consumed")
    public void testCheckingAddGuestToApartment(){
        int apartmentType=2;
        String corporationIsToBoreWellRatio="3:7";
        Apartment apartment=new Apartment(Constants.TWO_BHK,corporationIsToBoreWellRatio);
        apartment.addGuestToApartment(2);
        assertEquals(2,apartment.getNoOfAdditionalGuest());
        assertEquals(1500,apartment.getTotalWaterConsumed());
    }


}
