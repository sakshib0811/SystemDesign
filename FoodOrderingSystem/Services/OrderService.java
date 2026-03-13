package Services;

import java.util.*;

import Exception.InvalidOperationException;
import Exception.NotFoundException;
import Models.MenuItem;
import Models.Order;
import Models.OrderItem;
import Models.Restaurant;
import Repository.OrderRepository;
import Repository.RestaurantRepository;
import Repository.UserRepository;
import Util.IdGenerator;
import Models.OrderStatus;

public class OrderService {
    UserRepository userRepo;
    RestaurantRepository restaurantRepo;
    OrderRepository orderRepo;

    public OrderService(UserRepository userRepo, RestaurantRepository restaurantRepo, OrderRepository orderRepo) {
        this.userRepo = userRepo;
        this.restaurantRepo = restaurantRepo;
        this.orderRepo = orderRepo;
    }

    public String placeOrder(String userId, String restName, Map<String, Integer> items) {
        if (userRepo.findById(userId) == null)
            throw new NotFoundException("user not found");

        Restaurant restaurant = restaurantRepo.findByName(restName);
        if (restaurant == null)
            throw new NotFoundException("Restaurant not found");

        List<OrderItem> orderItem = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            MenuItem menuItem = restaurant.getCatalog().get(entry.getKey());
            if (menuItem == null)
                throw new NotFoundException("Item not found");

            if (menuItem.getItemQuantity() < entry.getValue())
                throw new InvalidOperationException("Insufficient Quantity");

            menuItem.reduceQuantity(entry.getValue());

            orderItem.add(new OrderItem(menuItem.getItemName(), entry.getValue(), menuItem.getItemprice()));
        }
        String orderId = IdGenerator.generateId();
        Order order = new Order(orderId, userId, restName, orderItem);
        orderRepo.save(order);
        return orderId;
    }

    public List<Order> getOrders(String userId) {
        return orderRepo.findByUser(userId);
    }

    public void cancelOrder(String orderId) {
        Order order = orderRepo.findById(orderId);
        if (order == null)
            throw new NotFoundException("order not found");

        if (order.getOrderStatus() == OrderStatus.CANCELLED)
            throw new InvalidOperationException("Already Cancelled");

        Restaurant restaurant = restaurantRepo.findByName(order.getRestName());

        for (OrderItem item : order.getItems()) {
            MenuItem menuItem = restaurant.getCatalog().get(item.getItemName());
            menuItem.increaseQuantity(item.getQuantity());
        }
        order.cancel();

    }

}
