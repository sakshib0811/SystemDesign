package BookMyShow;

import java.util.ArrayList;
import java.util.List;

import BookMyShow.Enum.BookingStatus;

public class Booking {
    String bookingId;
    Show show;
    List<Seats> bookedSeat = new ArrayList<>();
    BookingStatus status;
    double totalAmount;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seats> getBookedSeats() {
        return bookedSeat;
    }

    public void setBookedSeats(List<Seats> bookedSeats) {
        this.bookedSeat = bookedSeats;
    }

    public BookingStatus getBookingStatus() {
        return status;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.status = bookingStatus;
    }

    public double calculateTotalAmt() {
        generateBookingId();
        ;
        return bookedSeat.size() * show.getScreen().getSeats().size() * 100;
    }

    private void generateBookingId() {
        bookingId = "RPQ" + (int) (Math.random() * (52222 - 10001 + 1) + 10001);
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", show=" + show + ", bookedSeat=" + bookedSeat + ", status="
                + status + ", totalAmount=" + totalAmount + "]";
    }

}
