package Models;

import java.util.*;

public class Order {
    String orderId;
    String userId;
    String restName;
    private List<OrderItem> items;
    OrderStatus orderStatus;

    public Order(String orderId, String userId, String restName, List<OrderItem> items) {
        this.orderId = orderId;
        this.userId = userId;
        this.restName = restName;
        this.items = items;
        this.orderStatus = OrderStatus.CONFIRMED;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void cancel() {
        this.orderStatus = OrderStatus.CANCELLED;
        System.out.println("Your Order has been cancelled");
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", userId=" + userId + ", restName=" + restName + ", items=" + items
                + ", orderStatus=" + orderStatus + "]";
    }

}
