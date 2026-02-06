package OlaUber;

class Driver {
    String driverId;
    String driverName;
    DriverStatus driverStatus;

    Driver(String driverId, String driverName, DriverStatus driverStatus) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverStatus = driverStatus;
    }
}
