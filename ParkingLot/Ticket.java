package ParkingLot;

public class Ticket {
    long entryTime;
    ParkingSpot parkingSpot;
    Vehicle vehicle;

    Ticket(long time, ParkingSpot ps, Vehicle v) {
        this.entryTime = time;
        this.parkingSpot = ps;
        this.vehicle = v;
    }
}
