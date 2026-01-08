package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BookMyShow.Enum.City;

public class MovieController {

    List<Movie> allMovies;
    Map<City, List<Movie>> movieVsCity;

    MovieController() {
        allMovies = new ArrayList<>();
        movieVsCity = new HashMap<>();
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public Map<City, List<Movie>> getMovieVsCity() {
        return movieVsCity;
    }

    public void setMovieVsCity(Map<City, List<Movie>> movieVsCity) {
        this.movieVsCity = movieVsCity;
    }

    void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> m = movieVsCity.getOrDefault(city, new ArrayList<>());
        m.add(movie);
        movieVsCity.put(city, m);
    }

    Movie getMovieByName(String movieName) {
        for (Movie m : allMovies) {
            if ((m.getMovieName()).equals(movieName)) {
                return m;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByCity(City city) {
        return movieVsCity.get(city);
    }

    public void removeMovie(Movie movie, City city) {
        allMovies.remove(movie);
        List<Movie> temp = movieVsCity.get(city);
        temp.remove(movie);
        movieVsCity.put(city, temp);
    }

}
