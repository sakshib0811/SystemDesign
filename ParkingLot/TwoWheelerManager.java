package ParkingLot;

import java.util.List;

public class TwoWheelerManager extends ParkingSpotManager {

    TwoWheelerManager(List<ParkingSpot> parkingSpots) {
        super(parkingSpots);
    }

    @Override
    ParkingSpot findParkingSpace(Vehicle v) {
        for (ParkingSpot spot : list) {
            if (spot.isEmpty) {
                spot.parkVehicle(v);
                return spot;
            }
        }
        return null;
    }
}
