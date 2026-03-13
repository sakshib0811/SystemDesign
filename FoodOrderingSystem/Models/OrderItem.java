package Models;

public class OrderItem {
    private String itemName;
    private int quantity;
    private double priceAtOrder;

    public OrderItem(String itemName, int quantity, double priceAtOrder) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.priceAtOrder = priceAtOrder;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceAtOrder() {
        return priceAtOrder;
    }

    public void setPriceAtOrder(double priceAtOrder) {
        this.priceAtOrder = priceAtOrder;
    }

}
