package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BookMyShow.Enum.City;

public class TheaterController {

    Map<City, List<Theatre>> theaterVsCity;
    List<Theatre> allTheater;

    public TheaterController() {
        theaterVsCity = new HashMap<>();
        allTheater = new ArrayList<>();
    }

    public Map<City, List<Theatre>> getTheaterVsCity() {
        return theaterVsCity;
    }

    public List<Theatre> getAllTheater() {
        return allTheater;
    }

    public void setAllTheater(List<Theatre> allTheater) {
        this.allTheater = allTheater;
    }

    public void setTheaterVsCity(Map<City, List<Theatre>> theaterVsCity) {
        this.theaterVsCity = theaterVsCity;
    }

    public void addTheater(Theatre th, City city) {
        allTheater.add(th);
        List<Theatre> temp = theaterVsCity.getOrDefault(city, new ArrayList<>());
        temp.add(th);
        theaterVsCity.put(city, temp);
    }

    public Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {
        Map<Theatre, List<Show>> theatreVsShow = new HashMap<>();
        List<Theatre> theatres = theaterVsCity.get(city);

        for (Theatre th : theatres) {
            List<Show> movieShow = new ArrayList<>();
            List<Show> shows = th.getShow();
            for (Show sh : shows) {
                if (sh.getMovie().getMovieId() == movie.getMovieId()) {
                    movieShow.add(sh);
                }
            }
            if (!movieShow.isEmpty()) {
                theatreVsShow.put(th, movieShow);
            }
        }
        return theatreVsShow;
    }
}
