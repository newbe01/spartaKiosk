package domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> cart = new ArrayList<>();
    private int orderNumber = 1;
    private double totalPrice = 0;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void sumTotalPrice(double totalPrice) {
        this.totalPrice += totalPrice;
    }

    public void addCart(Product product) {
        cart.add(product);
    }

    public void clear() {
        cart.clear();
    }

    public List<Product> getCart() {
        return cart;
    }

    public double sumCartPrice() {
        return cart.stream().mapToDouble(Product::getPrice).sum();
    }

    public int getOrderNumber() {
        return orderNumber++;
    }
}
