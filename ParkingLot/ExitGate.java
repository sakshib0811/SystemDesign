package ParkingLot;

import java.util.List;

public class ExitGate {
    ParkingManagerFactory psFactory;

    ExitGate(ParkingManagerFactory psFactory) {
        this.psFactory = psFactory;
    }

    int computeCharge(Ticket ticket) {
        long duration = System.currentTimeMillis() - ticket.entryTime;
        System.out.println("Entry Time : " + ticket.entryTime + " " + "exit Time : " + System.currentTimeMillis());
        long hours = (long) Math.ceil(duration / (1000.0 * 60 * 60));
        System.out.println("hours : " + hours);
        int rate;
        if (ticket.vehicle.vehicleType == VehicleType.TWO_WHEELER)
            rate = 20;
        else if (ticket.vehicle.vehicleType == VehicleType.FOUR_WHEELER)
            rate = 40;
        else
            rate = 0;
        if (hours <= 1)
            return rate;
        else
            return (int) hours * rate;

    }

    void removeVehicle(Ticket ticket, List<ParkingSpot> parkingSpot) {
        ParkingSpotManager manager = psFactory.getParkingSpotManager(ticket.vehicle, parkingSpot);
        manager.removeVehicle(ticket.vehicle, parkingSpot);
    }
}
