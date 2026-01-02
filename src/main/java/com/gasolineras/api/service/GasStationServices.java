package com.gasolineras.api.service;

import com.gasolineras.api.client.GasStationClient;
import com.gasolineras.api.model.GasStation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Best practice: dependency injection via the constructor. Lombok automatically
                         // creates a constructor for gasStationClient.
public class GasStationServices {

    private final GasStationClient gasStationClient;

    public List<GasStation> getNearestStations(double LatUser, double LonUser, double radiusKm) {

        List<GasStation> allStations = gasStationClient.getAllStations();

        return allStations.stream()
                .peek(station -> {
                    double dist = calculateHaversineDistance(LatUser, LonUser, station.getLatitude(),
                            station.getLongitude());
                    station.setDistanceKm(dist);
                })
                .filter(station -> station.getDistanceKm() <= radiusKm)
                .sorted(Comparator.comparingDouble(GasStation::getDistanceKm))
                .collect(Collectors.toList());

    }

    private double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // km2 Earth radius

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = R * c;

        return distance;
    }
}
