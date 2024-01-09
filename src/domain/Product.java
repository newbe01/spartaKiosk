package domain;

public class Product extends Menu {

    private double price;

    public Product() {
    }

    public Product(String name, String desc) {
        super(name, desc);
    }

    public Product(String name, String desc, double price) {
        super(name, desc);
        this.price = price;
    }

    public void printMenu() {
        System.out.printf("%-15s | %s \n", getName(), getDesc());
    }

    public void printProd() {
        System.out.printf("%-15s | ₩ %.1f | %s \n", getName(),  getPrice(), getDesc());
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void printTotal() {
        System.out.printf("- %-15s | ₩ %.1f \n", getName(), getPrice());
    }
}
