package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpot = new ArrayList<>();
        for (int i = 1; i <= 150; i++) {
            parkingSpot.add(new ParkingSpot(i, 40));
        }

        ParkingManagerFactory psFactory = new ParkingManagerFactory();
        Vehicle v = new Vehicle(8112000, VehicleType.FOUR_WHEELER);
        Vehicle v1 = new Vehicle(13072000, VehicleType.TWO_WHEELER);

        EntryGate entryGate = new EntryGate(psFactory);
        ExitGate exitGate = new ExitGate(psFactory);

        System.out.println("Vehicle type for v : " + v.vehicleType);

        ParkingSpot parkingSpotV = entryGate.findParkingSpot(v, parkingSpot);
        Ticket ticketV = entryGate.generateTicket(v, parkingSpotV);

        System.out.println("Vehicle type for v1 : " + v1.vehicleType);
        ParkingSpot parkingSpotV1 = entryGate.findParkingSpot(v1, parkingSpot);
        Ticket ticketV1 = entryGate.generateTicket(v1, parkingSpotV1);

        exitGate.removeVehicle(ticketV, parkingSpot);
        System.out.println("Parking price for Vehicle V : " + exitGate.computeCharge(ticketV));

        Vehicle v2 = new Vehicle(4122019, VehicleType.TWO_WHEELER);

        ParkingSpot parkingSpotV2 = entryGate.findParkingSpot(v2, parkingSpot);
        Ticket ticketV2 = entryGate.generateTicket(v2, parkingSpotV2);

        System.out.println("Parking price for Vehicle V1 : " + exitGate.computeCharge(ticketV1));
        exitGate.removeVehicle(ticketV1, parkingSpot);

        System.out.println("Parking price for Vehicle V2 : " + exitGate.computeCharge(ticketV2));
        exitGate.removeVehicle(ticketV2, parkingSpot);

    }
}