import java.time.LocalDate;
import java.time.LocalDateTime;

class SeatInventory {
    String seatId;
    LocalDate journeyDate;
    SeatStatus seatStatus;
    String lockedBy;
    LocalDateTime lockExp;

    SeatInventory(String seatId, LocalDate journeyDate) {
        this.seatId = seatId;
        this.journeyDate = journeyDate;
        this.seatStatus = SeatStatus.AVAILABLE;
    }
}
