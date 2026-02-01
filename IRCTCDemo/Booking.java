import java.time.LocalDate;

class Booking {
    String bookingId;
    String userId;
    String trainNo;
    LocalDate journeyDate;
    BookingStatus bookingStatus;

    Booking(String bookingId, String userId, String trainNo, LocalDate journeyDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.trainNo = trainNo;
        this.journeyDate = journeyDate;
        this.bookingStatus = BookingStatus.INITIATED;
    }
}
