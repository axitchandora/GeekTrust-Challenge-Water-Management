package com.geektrust.backend.entites;

import com.geektrust.backend.constants.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("BillTest")
public class BillTest {

    @Test
    @DisplayName("should create a bill Object")
    public void shouldCreateABillObject() {
        int apartmentType= Constants.TWO_BHK;
        String corporationIsToBoreWellRatio="1:2";
        Apartment apartment=new Apartment(apartmentType,corporationIsToBoreWellRatio);
        Bill actualBill=new Bill(apartment,1200.0);
        assertEquals(1200.0,actualBill.getTotalAmount());
    }
}
