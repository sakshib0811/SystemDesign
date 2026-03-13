package Repository;

import java.util.*;

import Models.Order;

public class OrderRepository {
    private Map<String, Order> orders = new HashMap<>();
    private Map<String, List<Order>> userOrders = new HashMap<>();

    public void save(Order order) {
        orders.put(order.getOrderId(), order);
        userOrders.computeIfAbsent(order.getUserId(), k -> new ArrayList<>()).add(order);

    }

    public Order findById(String id) {
        return orders.get(id);
    }

    public List<Order> findByUser(String userId) {
        return userOrders.getOrDefault(userId, new ArrayList<>());
    }
}
