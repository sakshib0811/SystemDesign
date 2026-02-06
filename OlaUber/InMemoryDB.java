package OlaUber;

import java.util.*;

class InMemoryDB {

    static Map<String, Rider> riders = new HashMap<>();
    static Map<String, Driver> drivers = new HashMap<>();
    static Map<String, DriverLocation> driverLocations = new HashMap<>();
    static Map<String, Trip> trips = new HashMap<>();

    static {
        riders.put("R1", new Rider("R1", "Alice"));

        drivers.put("D1", new Driver("D1", "Bob", DriverStatus.ONLINE));
        drivers.put("D2", new Driver("D2", "John", DriverStatus.ONLINE));
        drivers.put("D3", new Driver("D3", "Mike", DriverStatus.ONLINE));

        driverLocations.put("D1", new DriverLocation("D1", 28.61, 77.23));
        driverLocations.put("D2", new DriverLocation("D2", 28.62, 77.22));
        driverLocations.put("D3", new DriverLocation("D3", 28.80, 77.50));
    }
}
