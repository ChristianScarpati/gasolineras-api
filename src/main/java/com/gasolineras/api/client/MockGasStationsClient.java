package com.gasolineras.api.client;

import com.gasolineras.api.model.GasStation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // dependency injection
public class MockGasStationsClient implements GasStationClient {

    @Override
    public List<GasStation> getAllStations() {
        List<GasStation> stations = new ArrayList<>();

        stations.add(new GasStation(
                "1",
                "North Gasoil",
                "false street 123",
                "REPSOL",
                40.416775,
                -3.703790,
                1.55, 1.65, 1.75,
                null));

        // another gas station
        stations.add(new GasStation(
                "2",
                "South Gasoil",
                "lejan street 122",
                "BP",
                40.416775,
                -3.703790,
                1.55, 1.65, 1.75,
                null));

        return stations;

    }
}
