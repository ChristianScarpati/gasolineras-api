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
    private Double latitude;
    private Double longitude;

    // prices
    private Double priceDiesel;
    private Double priceGasoline95;
    private Double priceGasoline98;

    // it doesnt come from the API
    private Double distanceKm;

}
