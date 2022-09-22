package com.geektrust.backend.entites;
import com.geektrust.backend.constants.Constants;
public class Apartment{
    private Integer typeOfApartment;
    private Integer noOfAdditionalGuest;
    private Integer totalNoOfTenants;
    private double allocatedWaterForCorporationWater;
    private double allocatedWaterForBoreWellWater;
    private Integer totalWaterConsumed;

    private Integer monthlyWaterAllocatedForTenants;

    public  Apartment(){}
    public Apartment(Integer typeOfApartment, String corporationIsToBoreWellRatio) {
        this.typeOfApartment = typeOfApartment;
        totalNoOfTenants=0;
        noOfAdditionalGuest=0;
        totalWaterConsumed=0;
        allocatedWaterForCorporationWater=0.0;
        allocatedWaterForBoreWellWater=0.0;
        monthlyWaterAllocatedForTenants=0;
        setTotalNoOfTenantsInApartment();
        setMonthlyWaterAllocatedForTenantsAndTotalWaterConsumed();
        allotWaterToCorporateAndBoreWell(corporationIsToBoreWellRatio);
    }

    private void setTotalNoOfTenantsInApartment(){
        if(typeOfApartment.equals(Constants.TWO_BHK)){
            totalNoOfTenants=Constants.TENANTS_IN_TWO_BHK;
        }else if(typeOfApartment.equals(Constants.THREE_BHK)){
            totalNoOfTenants=Constants.TENANTS_IN_THERE_BHK;
        }
    }

    private void allotWaterToCorporateAndBoreWell(String corporationIsToBoreWellRatio){
        String [] ratioSplit=corporationIsToBoreWellRatio.split(":");
        int corporateMultiplier=Integer.parseInt(ratioSplit[Constants.ZERO]);
        int boreWellMultiplier=Integer.parseInt(ratioSplit[Constants.ONE]);
        int sumOfMultiplier=corporateMultiplier+boreWellMultiplier;
        allocatedWaterForCorporationWater=(double)(totalWaterConsumed *corporateMultiplier)/sumOfMultiplier;
        allocatedWaterForBoreWellWater=(double)(totalWaterConsumed *boreWellMultiplier)/sumOfMultiplier;
    }

    private void setMonthlyWaterAllocatedForTenantsAndTotalWaterConsumed(){
        monthlyWaterAllocatedForTenants =totalNoOfTenants*Constants.CONSUMPTION_OF_A_PERSON_PER_DAY*Constants.NO_OF_DAYS_IN_A_MONTH;
        totalWaterConsumed =monthlyWaterAllocatedForTenants;
    }

    public void addGuestToApartment(int noOfGuest){
        noOfAdditionalGuest+=noOfGuest;
        totalWaterConsumed+=noOfGuest*Constants.NO_OF_DAYS_IN_A_MONTH*Constants.CONSUMPTION_OF_A_PERSON_PER_DAY;
    }

    public Integer getNoOfAdditionalGuest() {
        return noOfAdditionalGuest;
    }

    public double getAllocatedWaterForCorporationWater() {
        return allocatedWaterForCorporationWater;
    }

    public double getAllocatedWaterForBoreWellWater() {
        return allocatedWaterForBoreWellWater;
    }

    public Integer getTotalWaterConsumed() {
        return totalWaterConsumed;
    }

    public Integer getMonthlyWaterAllocatedForTenants() {
        return monthlyWaterAllocatedForTenants;
    }

}
