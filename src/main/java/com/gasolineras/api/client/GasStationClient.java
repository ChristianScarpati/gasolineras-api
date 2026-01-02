package com.gasolineras.api.client;

import com.gasolineras.api.model.GasStation;
import java.util.List;



public interface GasStationClient {
    // list of gas stations
    List<GasStation> getAllStations();

}
