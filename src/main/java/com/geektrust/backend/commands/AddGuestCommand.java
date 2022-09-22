package com.geektrust.backend.commands;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.exceptions.NoSuchCommandException;
import com.geektrust.backend.services.IApartmentBillService;
import java.util.List;

public class AddGuestCommand implements ICommand{
    private final IApartmentBillService apartmentBillService;

    public AddGuestCommand(IApartmentBillService apartmentBillService) {
        this.apartmentBillService = apartmentBillService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            apartmentBillService.addGuestToApartment(Integer.valueOf(tokens.get(Constants.ONE)));
        } catch (NoSuchCommandException e) {
            System.out.println("Invalid Command");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
