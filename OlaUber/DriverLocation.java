package OlaUber;

class DriverLocation {

    String driverId;
    double lon;
    double lat;
    long lastUpdate;

    DriverLocation(String driverId, double lat, double lon) {
        this.driverId = driverId;
        this.lat = lat;
        this.lon = lon;
        this.lastUpdate = System.currentTimeMillis();
    }
}
