package com.geektrust.backend.services;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.dto.GeneratedBillDto;
import com.geektrust.backend.entites.Apartment;
import com.geektrust.backend.entites.Bill;

public class ApartmentBillService implements IApartmentBillService {

    private Apartment apartment;

    public ApartmentBillService() {
        this.apartment = new Apartment();
    }

    @Override
    public void allotWaterForApartment(Integer typeOfApartment, String corporationIsToBoreWellRatio) {
        apartment=new Apartment(typeOfApartment,corporationIsToBoreWellRatio);
    }

    @Override
    public void addGuestToApartment(Integer noOfGuests) {
        apartment.addGuestToApartment(noOfGuests);
    }

    @Override
    public GeneratedBillDto calculateBillForApartment() {
        double totalAmount=calculateBillForCorporateWater()+calculateBillForBoreWellWater()+calculateBillForTankerWater();
        Bill bill=new Bill(apartment,totalAmount);
        return new GeneratedBillDto(apartment.getTotalWaterConsumed(),(int) Math.ceil(totalAmount));
    }

    private double calculateBillForCorporateWater(){
        return apartment.getAllocatedWaterForCorporationWater()*Constants.CORPORATION_WATER_RATE;
    }

    private double calculateBillForBoreWellWater(){
        return apartment.getAllocatedWaterForBoreWellWater()*Constants.BOREWELL_WATER_RATE;
    }

    private double calculateBillForTankerWater(){
        int totalWaterForAdditionalGuests=apartment.getTotalWaterConsumed()-apartment.getMonthlyWaterAllocatedForTenants();
        double billForTankerWater=0.0;
        if(totalWaterForAdditionalGuests<=Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE){
            billForTankerWater+=totalWaterForAdditionalGuests*Constants.TANKER_WATER_SLAB_0_TO_500L_RATE;
        }else if(totalWaterForAdditionalGuests > Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE
                && totalWaterForAdditionalGuests<=Constants.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE){
            billForTankerWater+=((Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE*Constants.TANKER_WATER_SLAB_0_TO_500L_RATE)+
                    (totalWaterForAdditionalGuests-Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE)*Constants.TANKER_WATER_SLAB_501_TO_1500L_RATE);
        }else if(totalWaterForAdditionalGuests > Constants.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE &&totalWaterForAdditionalGuests<=Constants.TANKER_WATER_SLAB_1501_TO_3000L_MAX_VALUE){
            billForTankerWater+=((Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE*Constants.TANKER_WATER_SLAB_0_TO_500L_RATE)+(Constants.TANKER_WATER_SLAB_501_TO_1500L_Difference*Constants.TANKER_WATER_SLAB_501_TO_1500L_RATE)+
                    (totalWaterForAdditionalGuests-Constants.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE)*Constants.TANKER_WATER_SLAB_1501_TO_3000L_RATE);
        }else{
            billForTankerWater+=((Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE*Constants.TANKER_WATER_SLAB_0_TO_500L_RATE)+
                    (Constants.TANKER_WATER_SLAB_501_TO_1500L_Difference*Constants.TANKER_WATER_SLAB_501_TO_1500L_RATE)+
                    (Constants.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE*Constants.TANKER_WATER_SLAB_1501_TO_3000L_RATE)+
                    (totalWaterForAdditionalGuests-Constants.TANKER_WATER_SLAB_1501_TO_3000L_MAX_VALUE)*Constants.TANKER_WATER_SLAB_3001_PLUS_RATE);
        }
        return billForTankerWater;
    }


}
