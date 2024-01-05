package domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> cart = new ArrayList<>();
    private int orderNumber = 1;

    public void addCart(Product product) {
        cart.add(product);
    }

    public void clear() {
        cart.clear();
    }

    public List<Product> getCart() {
        return cart;
    }

    public double getTotal() {
        return cart.stream().mapToDouble(Product::getPrice).sum();
    }

    public int getOrderNumber() {
        return orderNumber++;
    }
}
