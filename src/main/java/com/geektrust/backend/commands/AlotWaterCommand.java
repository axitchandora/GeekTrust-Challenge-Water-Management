package com.geektrust.backend.commands;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.exceptions.NoSuchCommandException;
import com.geektrust.backend.services.IApartmentBillService;

import java.util.List;

public class AlotWaterCommand implements ICommand{
    private final IApartmentBillService apartmentBillService;

    public AlotWaterCommand(IApartmentBillService apartmentBillService) {
        this.apartmentBillService = apartmentBillService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            apartmentBillService.allotWaterForApartment(Integer.valueOf(tokens.get(Constants.ONE)),tokens.get(Constants.TWO));
        } catch (NoSuchCommandException e) {
            System.out.println("Invalid Command");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
