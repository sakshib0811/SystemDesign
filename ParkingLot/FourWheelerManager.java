package ParkingLot;

import java.util.List;

public class FourWheelerManager extends ParkingSpotManager {

    FourWheelerManager(List<ParkingSpot> parkingSpots) {
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
