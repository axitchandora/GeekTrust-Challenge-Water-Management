package com.geektrust.backend.service;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.dto.GeneratedBillDto;
import com.geektrust.backend.entites.Apartment;
import com.geektrust.backend.services.ApartmentBillService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@DisplayName("ApartmentBillServiceTest")
@ExtendWith(MockitoExtension.class)
public class ApartmentBillServiceTest {

    @Mock
    private ApartmentBillService apartmentBillServiceMock;

    @Test
    @DisplayName("should Generate Bill For Apartment")
    public void shouldGenerateBillForApartments(){
        //Arrange
        String corporationIsToBoreWellRatio="1:2";
        Apartment expectedApartment = new Apartment(Constants.TWO_BHK, corporationIsToBoreWellRatio);
        GeneratedBillDto generatedBillDtoExpected=new GeneratedBillDto(900,1200);
        when(apartmentBillServiceMock.calculateBillForApartment()).thenReturn(generatedBillDtoExpected);

        //Act
        GeneratedBillDto generatedBillDtoActual = apartmentBillServiceMock.calculateBillForApartment();

        //Assert
        Assertions.assertEquals(generatedBillDtoExpected,generatedBillDtoActual);
        verify(apartmentBillServiceMock,times(1)).calculateBillForApartment();
    }



}
