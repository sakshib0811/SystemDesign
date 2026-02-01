import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        BookingService bookingService = new BookingService();
        String bookingId = bookingService.initateBooking("User1", "12345", LocalDate.of(2026, 02, 01), "2AC", 1);
        System.out.println("Booking initiated : " + bookingId);
        bookingService.confirBooking(bookingId);
        System.out.println("Booking Confirmed");
        System.out.println("final Seat Status : ");
        InMemoryDB.seatInventory.values().forEach(st -> System.out.println(st.seatId + " -> " + st.seatStatus));

    }
}
