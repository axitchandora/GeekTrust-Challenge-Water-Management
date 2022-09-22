package com.geektrust.backend.dto;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.entites.Apartment;
import com.geektrust.backend.entites.Bill;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("GeneratedBillDtoTest")
public class GeneratedBillDtoTest {
    @Test
    @DisplayName("should create a GeneratedBillDto Object")
    public void shouldCreateAGeneratedBillDtoObject() {
        GeneratedBillDto generatedBillDto=new GeneratedBillDto(900,1200);
        String expectedString="900 1200";
        String acutalString=generatedBillDto.toString();
        assertEquals(expectedString,acutalString);
    }
}
