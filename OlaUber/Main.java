package OlaUber;

public class Main {
    public static void main(String[] args) {
        TripService tripSer = new TripService();

        try {
            System.out.println("Rider rquesting ride ...");

            String tripId = tripSer.requestride("R1", "HOODI", "INDIRANAGAR", 28.61, 77.32);

            System.out.println("Trip requested : " + tripId);
            tripSer.acceptRide(tripId);

            System.out.println("trip Accepted");

            tripSer.startTrip(tripId);
            System.out.println("Trip started");

            tripSer.endTrip(tripId);
            System.out.println("Trip ended");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
