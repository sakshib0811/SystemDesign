package ParkingLot;

import java.util.List;

public class ParkingManagerFactory {

    ParkingSpotManager getParkingSpotManager(Vehicle v, List<ParkingSpot> parkingSpot) {
        if (v.vehicleType == VehicleType.TWO_WHEELER) {
            return new TwoWheelerManager(parkingSpot);
        } else if (v.vehicleType == VehicleType.FOUR_WHEELER) {
            return new FourWheelerManager(parkingSpot);
        } else {
            System.out.println("Invalid vehicle type");
            return null;
        }
    }

}
