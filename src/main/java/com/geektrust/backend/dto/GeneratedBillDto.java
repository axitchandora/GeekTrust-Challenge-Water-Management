package com.geektrust.backend.dto;

public class GeneratedBillDto {
    private Integer totalWaterConsumed;
    private Integer totalCost;

    public GeneratedBillDto(Integer totalWaterConsumed, Integer totalCost) {
        this.totalWaterConsumed = totalWaterConsumed;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return totalWaterConsumed +" " + totalCost;
    }



}
