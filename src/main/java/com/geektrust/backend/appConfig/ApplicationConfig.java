package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.*;
import com.geektrust.backend.services.ApartmentBillService;
import com.geektrust.backend.services.IApartmentBillService;

public class ApplicationConfig {

    private final IApartmentBillService apartmentBillService=new ApartmentBillService();
    private final AlotWaterCommand alotWaterCommand=new AlotWaterCommand(apartmentBillService);
    private final AddGuestCommand addGuestCommand=new AddGuestCommand(apartmentBillService);
    private final BillCommand billCommand=new BillCommand(apartmentBillService);
    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("ALLOT_WATER",alotWaterCommand);
        commandInvoker.register("ADD_GUESTS",addGuestCommand);
        commandInvoker.register("BILL",billCommand);
        return commandInvoker;
    }
}
