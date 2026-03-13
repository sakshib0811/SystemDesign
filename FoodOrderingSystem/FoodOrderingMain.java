import Repository.*;
import Services.*;

import java.util.*;

import Models.Order;

public class FoodOrderingMain {

    public static void main(String[] args) {

        UserRepository userRepo = new UserRepository();
        RestaurantRepository restaurantRepo = new RestaurantRepository();
        OrderRepository orderRepo = new OrderRepository();

        UserService userService = new UserService(userRepo);
        RestaurantService restaurantService = new RestaurantService(restaurantRepo);
        OrderService orderService = new OrderService(userRepo, restaurantRepo, orderRepo);

        String user1 = userService.register("User1", "user1@mail.com", "1234567890");
        String user2 = userService.register("User2", "user2@mail.com", "1234567891");

        System.out.println(userRepo.findById(user2));

        String rest1Id = restaurantService.register("PizzaHut", "GST123", "res@mail.com", "999999");
        restaurantService.addItem("PizzaHut", "Sandwich", 10, 10);
        restaurantService.addItem("PizzaHut", "Pizza", 200, 3);

        restaurantService.addItem("PizzaHut", "Pizza", 150, 3);

        System.out.println(restaurantRepo.findById(rest1Id));

        System.out.println("Searching Items in restaurant");

        restaurantService.searchItems(rest1Id, "Pizza")
                .forEach(item -> System.out.println(item.getItemName() + " " + item.getItemprice()));

        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("Sandwich", 3);
        orderItems.put("Pizza", 1);

        Map<String, Integer> orderItems1 = new HashMap<>();
        orderItems1.put("Sandwich", 1);

        String order1 = orderService.placeOrder(user1, "PizzaHut", orderItems);

        orderService.placeOrder(user1, "PizzaHut", orderItems1);

        System.out.println("Orders: " + orderService.getOrders(user1).size());
        orderService.cancelOrder(order1);

        String order2 = orderService.placeOrder(user2, "PizzaHut", orderItems);

        System.out.println("Orders: " + orderService.getOrders(user2).size());

        List<Order> userOrder = orderService.getOrders(user2);

        for (int i = 0; i < userOrder.size(); i++)
            System.out.println(userOrder.get(i).getItems().get(i).getItemName() + " ");

        orderService.cancelOrder(order2);

        // System.out.println("Order cancelled successfully");
    }
}