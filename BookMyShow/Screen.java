package BookMyShow;

import java.util.List;

public class Screen {
    int screenId;
    List<Seats> seats;

    public List<Seats> getSeats() {
        return seats;
    }

    public void setSeats(List<Seats> seats) {
        this.seats = seats;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    @Override
    public String toString() {
        return "Screen [screenId=" + screenId + ", seats=" + seats + "]";
    }
}
