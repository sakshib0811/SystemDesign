import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;

class BookingService {
    private final SeatInventoryStore inventoryStore = new SeatInventoryStore();

    String initateBooking(String userId, String trainNo, LocalDate date, String classType, int seatCount) {
        List<String> availableSeats = inventoryStore.findAvailableSeat(trainNo, date, classType);
        System.out.println(availableSeats.size() + " ");
        if (availableSeats.size() < seatCount) {
            throw new RuntimeErrorException(null, "Not enough seat available");
        }

        String bookingId = UUID.randomUUID().toString();
        List<String> bookedSeat = new ArrayList<>();
        for (int i = 0; i < seatCount; i++) {
            String seatId = availableSeats.get(i);
            boolean locked = inventoryStore.lockSeat(seatId, userId, date);
            if (!locked) {
                throw new RuntimeException("seat locked failed!! Try Again");
            }
            bookedSeat.add(seatId);
        }

        Booking booking = new Booking(bookingId, userId, trainNo, date);
        InMemoryDB.booking.put(bookingId, booking);
        InMemoryDB.bookingSeat.put(bookingId, bookedSeat);

        return bookingId;

    }

    void confirBooking(String bookingId) {
        Booking booking = InMemoryDB.booking.get(bookingId);
        List<String> seats = InMemoryDB.bookingSeat.get(bookingId);

        for (String seatId : seats) {
            inventoryStore.bookSeat(seatId, booking.journeyDate);
        }

        booking.bookingStatus = BookingStatus.CONFIRMED;
    }
}
