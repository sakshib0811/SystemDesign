package ParkingLot;

public class ParkingSpot {

    int id;
    boolean isEmpty;
    Vehicle vehicle;
    int price;

    ParkingSpot(int id, int price) {
        this.id = id;
        this.isEmpty = true;
        this.vehicle = null;
        this.price = price;
    }

    void parkVehicle(Vehicle v) {
        System.out.println("id : " + this.id);
        this.vehicle = v;
        this.isEmpty = false;
    }

    void removeVehicle(Vehicle v) {
        this.vehicle = null;
        this.isEmpty = true;
    }
}
