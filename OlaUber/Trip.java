package OlaUber;

class Trip {

    String tripId;
    String riderId;
    String driverId;
    String source;
    String destination;
    TripStatus status;

    Trip(String tripId, String riderId, String driverId, String source, String destination) {
        this.tripId = tripId;
        this.riderId = riderId;
        this.driverId = driverId;
        this.source = source;
        this.destination = destination;
        this.status = TripStatus.REQUESTED;
    }
}
