package com.geektrust.backend.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("ConstantsTest")
public class ConstantsTest {

    @Test
    @DisplayName("Testing Constants Value")
    public void testCheckingConstantsValue(){
        assertEquals(10,Constants.CONSUMPTION_OF_A_PERSON_PER_DAY );
        assertNotEquals(25,Constants.NO_OF_DAYS_IN_A_MONTH);
        assertEquals(1500,Constants.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE);
        assertEquals(1000,Constants.TANKER_WATER_SLAB_501_TO_1500L_Difference );
        assertNotEquals(2,Constants.TENANTS_IN_TWO_BHK);
    }
}
