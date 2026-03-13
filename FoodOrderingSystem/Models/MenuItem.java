package Models;

public class MenuItem {
    String itemName;
    double itemprice;
    int itemQuantity;

    public MenuItem(String itemName, double itemprice, int itemQuantity) {
        this.itemName = itemName;
        this.itemprice = itemprice;
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemprice() {
        return itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void reduceQuantity(int q) {
        this.itemQuantity -= q;
    }

    public void increaseQuantity(int q) {
        this.itemQuantity += q;
    }

    @Override
    public String toString() {
        return "MenuItem [itemName=" + itemName + ", itemprice=" + itemprice + ", itemQuantity=" + itemQuantity + "]";
    }

}
