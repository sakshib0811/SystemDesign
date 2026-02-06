package OlaUber;

import java.util.UUID;

class TripService {

    private final MatchingService mService = new MatchingService();

    String requestride(String riderId, String src, String des, double lat, double lon) {
        String driverId = mService.findNearestDriver(lat, lon);

        String tripId = UUID.randomUUID().toString();

        Trip trip = new Trip(tripId, riderId, driverId, src, des);

        InMemoryDB.trips.put(tripId, trip);
        return tripId;

    }

    void acceptRide(String tripId) {
        Trip trip = InMemoryDB.trips.get(tripId);
        Driver driver = InMemoryDB.drivers.get(trip.driverId);

        trip.status = TripStatus.ACCEPTED;
        driver.driverStatus = DriverStatus.BUSY;
    }

    void startTrip(String tripId) {
        InMemoryDB.trips.get(tripId).status = TripStatus.IN_PROGRESS;
    }

    void endTrip(String tripId) {
        Trip trip = InMemoryDB.trips.get(tripId);
        trip.status = TripStatus.COMPLETED;
        Driver driver = InMemoryDB.drivers.get(trip.driverId);
        driver.driverStatus = DriverStatus.ONLINE;
    }
}
