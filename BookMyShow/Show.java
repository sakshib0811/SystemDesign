package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Show {
    int showId;
    Movie movie;
    Screen screen;
    int startTime;
    List<Integer> bookingSeatId = new ArrayList<>();

    public List<Integer> getBookingSeatId() {
        return bookingSeatId;
    }

    public void setBookingSeatId(List<Integer> bookingSeatId) {
        this.bookingSeatId = bookingSeatId;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    @Override
    public String toString() {
        return "Show [showId=" + showId + ", movie=" + movie + ", screen=" + screen + ", startTime=" + startTime
                + ", bookingSeatId=" + bookingSeatId + "]";
    }

}
