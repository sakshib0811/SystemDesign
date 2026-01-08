package BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import BookMyShow.Enum.BookingStatus;
import BookMyShow.Enum.City;
import BookMyShow.Enum.SeatCategory;

public class BookMyShow {
    MovieController mc;
    TheaterController tc;

    BookMyShow() {
        mc = new MovieController();
        tc = new TheaterController();
    }

    public static void main(String[] main) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        System.out.println("\n===> Booking seat 28 for movie ABC in Bangalore for customer 1");
        Customer c1 = new Customer("1", "Sakshi", "sakshi@abc.com", "123456789", "103, Main road");
        bookMyShow.createBooking(c1, City.BANGALORE, "Agc");

        Customer c2 = new Customer("2", "Aman", "aman@abc.com", "987654321", "D-55, Main road");
        bookMyShow.createBooking(c2, City.BANGALORE, "xyz");
    }

    private void createBooking(Customer customer, City city, String movieName) {
        List<Movie> movie = mc.getMoviesByCity(city);

        Movie intrestedMovie = null;
        for (Movie m : movie) {
            if ((m.getMovieName()).equals(movieName)) {
                intrestedMovie = m;
            }
        }
        System.out.println(intrestedMovie);
        if (intrestedMovie != null) {

            Map<Theatre, List<Show>> theaterWiseShow = tc.getAllShow(intrestedMovie, city);

            Map.Entry<Theatre, List<Show>> entry = theaterWiseShow.entrySet().iterator().next();
            List<Show> runningShow = entry.getValue();
            Show interestedShow = runningShow.get(0);

            int seatNumber = 28;
            List<Integer> bookedSeat = interestedShow.getBookingSeatId();
            if (!bookedSeat.contains(seatNumber)) {
                bookedSeat.add(seatNumber);
                Booking booking = new Booking();
                List<Seats> myBookedSeats = new ArrayList<>();
                for (Seats s : interestedShow.getScreen().getSeats()) {
                    if (s.getSeatId() == seatNumber) {
                        myBookedSeats.add(s);
                    }
                }
                booking.setBookedSeats(myBookedSeats);
                booking.setShow(interestedShow);
                booking.setBookingStatus(BookingStatus.COMPLETED);
                customer.addBooking(booking);
            }

            else {
                System.out.println("BOOKING FAILED! Seat already booked. Please try again!");
                return;
            }
        } else {
            System.out.println("Intrested movie is not there in your city");
            return;
        }
        System.out.println("BOOKING SUCCESSFUL!");

    }

    private void initialize() {
        createMovies();
        createTheater();
    }

    private void createMovies() {
        Movie m1 = new Movie();
        m1.setMovieId(1);
        m1.setMovieName("Abc");
        m1.setMovieDuration(180);

        Movie m2 = new Movie();
        m2.setMovieId(2);
        m2.setMovieName("Xyz");
        m2.setMovieDuration(120);

        mc.addMovie(m1, City.BANGALORE);
        mc.addMovie(m2, City.MUMBAI);
        mc.addMovie(m2, City.DELHI);
    }

    private void createTheater() {
        Movie abcMovie = mc.getMovieByName("Abc");
        Movie xyzMovie = mc.getMovieByName("Xyz");

        Theatre pvrTheater = new Theatre();
        pvrTheater.setTheatreId(1);
        pvrTheater.setCity(City.BANGALORE);
        pvrTheater.setScreen(createScreen(1));
        List<Show> show = new ArrayList<>();
        Show morningShow = createShow(1, pvrTheater.getScreen().get(0), abcMovie, 8);
        Show eveningShow = createShow(2, pvrTheater.getScreen().get(0), xyzMovie, 20);
        show.add(morningShow);
        show.add(eveningShow);
        pvrTheater.setShow(show);
        tc.addTheater(pvrTheater, City.BANGALORE);

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(2);
        inoxTheatre.setCity(City.DELHI);
        inoxTheatre.setScreen(createScreen(1));
        List<Show> inoxShow = new ArrayList<>();
        Show inoxMorningShow = createShow(3, inoxTheatre.getScreen().get(0), abcMovie, 10);
        Show inoxEveningShow = createShow(4, inoxTheatre.getScreen().get(0), xyzMovie, 15);
        inoxShow.add(inoxMorningShow);
        inoxShow.add(inoxEveningShow);
        inoxTheatre.setShow(inoxShow);
    }

    private List<Screen> createScreen(int i) {
        List<Screen> screens = new ArrayList<>();
        Screen sc = new Screen();
        int screenNo = 1;
        while (i > 0) {
            sc.setScreenId(screenNo++);
            sc.setSeats(createSeats());
            screens.add(sc);
            sc = new Screen();
            i--;
        }
        return screens;

    }

    private Show createShow(int id, Screen sc, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setShowId(id);
        show.setScreen(sc);
        show.setMovie(movie);
        show.setStartTime(showStartTime);
        return show;
    }

    private List<Seats> createSeats() {
        List<Seats> seats = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            Seats st = new Seats();
            st.setSeatId(i);
            st.setSc(SeatCategory.SILVER);
            st.setPrice(200);
            seats.add(st);
        }
        for (int i = 40; i < 60; i++) {
            Seats st = new Seats();
            st.setSeatId(i);
            st.setSc(SeatCategory.GOLD);
            st.setPrice(300);
            seats.add(st);
        }
        for (int i = 60; i < 70; i++) {
            Seats st = new Seats();
            st.setSeatId(i);
            st.setSc(SeatCategory.VIP);
            st.setPrice(500);
            seats.add(st);
        }
        return seats;
    }
}
