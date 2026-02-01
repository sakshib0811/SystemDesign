import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class SeatInventoryStore {
    boolean lockSeat(String seatId, String userId, LocalDate date) {
        SeatInventory st = InMemoryDB.seatInventory.get(InMemoryDB.inventoryKey(seatId, date));
        if (st.seatStatus != SeatStatus.AVAILABLE) {
            System.out.println("Seat Not available");
            return false;
        }
        st.seatStatus = SeatStatus.LOCKED;
        st.lockedBy = userId;
        st.lockExp = LocalDateTime.now().plusMinutes(5);
        return true;
    }

    void bookSeat(String seatId, LocalDate date) {
        SeatInventory st = InMemoryDB.seatInventory.get(InMemoryDB.inventoryKey(seatId, date));
        if (st.seatStatus == SeatStatus.LOCKED) {
            st.seatStatus = SeatStatus.BOOKED;
        }
    }

    List<String> findAvailableSeat(String trainNo, LocalDate date, String classType) {
        System.out.println(" storeDate" + date + " ");
        List<String> result = new ArrayList<>();
        for (SeatInventory st : InMemoryDB.seatInventory.values()) {
            Seat seat = InMemoryDB.seat.get(st.seatId);
            if (st.journeyDate.equals(date) && st.seatStatus.equals(SeatStatus.AVAILABLE)
                    && seat.trainNo.equals(trainNo) && seat.classType.equals(classType)) {
                result.add(seat.seatId);
            }
        }
        return result;
    }
}
