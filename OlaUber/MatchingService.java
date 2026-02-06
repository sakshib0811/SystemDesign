package OlaUber;

class MatchingService {
    private static final double maxPickupAllowed = 5.0;

    String findNearestDriver(double lat, double lon) {

        double minDistance = Double.MAX_VALUE;
        String nearestDriverId = null;

        for (Driver d : InMemoryDB.drivers.values()) {
            if (d.driverStatus != DriverStatus.ONLINE)
                continue;

            DriverLocation loc = InMemoryDB.driverLocations.get(d.driverId);
            if (loc == null)
                continue;

            double dis = calculateDistance(lat, lon, loc.lat, loc.lon);

            if (dis < minDistance) {
                minDistance = dis;
                nearestDriverId = d.driverId;
            }
        }

        if (nearestDriverId == null || minDistance > maxPickupAllowed) {
            throw new RuntimeException("Currently no driver Available...");
        }
        return nearestDriverId;
    }

    private double calculateDistance(double lat, double lon, double lat1, double lon1) {
        double dx = lat - lat1;
        double dy = lon - lon1;
        return Math.sqrt(dx * dx + dy * dy) * 111;
    }
}
