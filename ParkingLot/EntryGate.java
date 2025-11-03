package ParkingLot;

import java.util.List;

public class EntryGate {

    ParkingManagerFactory psFactory;

    EntryGate(ParkingManagerFactory psFactory) {
        this.psFactory = psFactory;
    }

    ParkingSpot findParkingSpot(Vehicle v, List<ParkingSpot> ParkingSpot) {
        ParkingSpotManager psManager = psFactory.getParkingSpotManager(v, ParkingSpot);
        return psManager.findParkingSpace(v);
    }

    Ticket generateTicket(Vehicle v, ParkingSpot parkingSpot) {
        long entryTime = System.currentTimeMillis();
        return new Ticket(entryTime, parkingSpot, v);
    }

}
