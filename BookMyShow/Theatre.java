package BookMyShow;

import java.util.ArrayList;
import java.util.List;

import BookMyShow.Enum.City;

public class Theatre {
    int theatreId;
    List<Show> show = new ArrayList<>();
    List<Screen> screen = new ArrayList<>();
    City city;

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public List<Show> getShow() {
        return show;
    }

    public void setShow(List<Show> show) {
        this.show = show;
    }

    public List<Screen> getScreen() {
        return screen;
    }

    public void setScreen(List<Screen> screen) {
        this.screen = screen;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Theatre [theatreId=" + theatreId + ", show=" + show + ", screen=" + screen + ", city=" + city + "]";
    }

}
