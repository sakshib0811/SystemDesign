package Repository;

import Models.Restaurant;
import java.util.*;

public class RestaurantRepository {

    private Map<String, Restaurant> restaurantsById = new HashMap<>();
    private Map<String, Restaurant> restaurantsByName = new HashMap<>();

    public void save(Restaurant r) {
        restaurantsById.put(r.getRestid(), r);
        restaurantsByName.put(r.getRestName(), r);
    }

    public Restaurant findById(String id) {
        return restaurantsById.get(id);
    }

    public Restaurant findByName(String name) {
        return restaurantsByName.get(name);
    }

    public boolean existsByName(String name) {
        return restaurantsByName.containsKey(name);
    }
}