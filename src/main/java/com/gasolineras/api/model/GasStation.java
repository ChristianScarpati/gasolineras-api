package com.gasolineras.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GasStation {
    
    private String id;
    private String name;
    private String address;
    private String brand;

    // coordinates to calcualte x and y
    private double latitude;
    private double longitude;

    //prices
    private double priceDiesel;
    private double priceGasoline95;
    private double priceGasoline98;

    // it doesnt come from the API
    private double DistanceKm;


}
