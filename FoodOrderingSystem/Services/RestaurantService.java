package Services;

import Exception.InvalidOperationException;
import Exception.NotFoundException;
import Models.MenuItem;
import Models.Restaurant;
import Repository.RestaurantRepository;
import Util.IdGenerator;
import java.util.*;

public class RestaurantService {
    RestaurantRepository repo;

    public RestaurantService(RestaurantRepository repo) {
        this.repo = repo;
    }

    // to register new Restaurant
    public String register(String name, String gst, String email, String phone) {
        if (name == null || name.isEmpty())
            throw new InvalidOperationException("invalid restaurant Name");
        if (repo.findByName(name) != null)
            throw new InvalidOperationException("restaurant already present");
        String id = IdGenerator.generateId();
        repo.save(new Restaurant(id, name, gst, email, phone));
        return id;
    }

    // add items and their price and quantity in Catelog
    public void addItem(String name, String item, double price, int quantity) {
        Restaurant r = repo.findByName(name);
        if (r == null)
            throw new NotFoundException("Restaurant not found!! Try Again");
        if (quantity <= 0)
            throw new InvalidOperationException("Invalid quantity");
        if (price <= 0)
            throw new InvalidOperationException("Invalid price, it should be more than 0");
        r.getCatalog().put(item, new MenuItem(item, price, quantity));
    }

    public List<MenuItem> searchItems(String restId, String itemName) {
        Restaurant restaurant = repo.findById(restId);
        if (restaurant == null)
            throw new NotFoundException("Restaurant not found");

        List<MenuItem> res = new ArrayList<>();
        for (MenuItem item : restaurant.getCatalog().values()) {
            if (item.getItemName().toLowerCase().contains(itemName.toLowerCase())) {

                res.add(item);
            }
        }
        if (res.isEmpty()) {
            throw new NotFoundException("Item not found");
        }
        res.sort(Comparator.comparingDouble(MenuItem::getItemprice));
        return res;
    }
}
