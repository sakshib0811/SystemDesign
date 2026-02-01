import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InMemoryDB {

    static Map<String, Seat> seat = new HashMap<>();
    static Map<String, SeatInventory> seatInventory = new HashMap<>();
    static Map<String, Booking> booking = new HashMap<>();
    static Map<String, List<String>> bookingSeat = new HashMap<>();

    static String inventoryKey(String seatId, LocalDate journeyDate) {
        return seatId + "_" + journeyDate;
    }

    static {
        seat.put("s1", new Seat("s1", "12345", "A1", "3AC", "LOWER"));
        seat.put("s2", new Seat("s2", "12345", "B1", "2AC", "UPPER"));
        seat.put("s3", new Seat("s3", "12345", "A2", "1AC", "MIDDLE"));

        LocalDate journeyDate = LocalDate.of(2026, 02, 01);
        for (String seatId : seat.keySet()) {
            seatInventory.put(inventoryKey(seatId, journeyDate), new SeatInventory(seatId, journeyDate));
        }
    }

}
