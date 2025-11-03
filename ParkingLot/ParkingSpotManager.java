package ParkingLot;

import java.util.List;

abstract class ParkingSpotManager {
    List<ParkingSpot> list;

    ParkingSpotManager(List<ParkingSpot> list) {
        this.list = list;
    }

    abstract ParkingSpot findParkingSpace(Vehicle v);

    void addParkingSpace(ParkingSpot spot) {
        this.list.add(spot);
    }

    void removeParkingSpace(ParkingSpot spot) {
        list.removeIf(ps -> ps.equals(spot));

    }

    void parkVehicle(Vehicle v) {
        ParkingSpot spot = findParkingSpace(v);
        if (spot == null) {
            System.out.println("Parking space is not Available!!!");
            return;
        }
        spot.parkVehicle(v);
    }

    void removeVehicle(Vehicle v, List<ParkingSpot> parkingSpots) {
        for (ParkingSpot spot : list) {
            if (spot.vehicle != null && spot.vehicle.equals(v)) {
                spot.removeVehicle(v);
                break;
            }
        }
    }

}
