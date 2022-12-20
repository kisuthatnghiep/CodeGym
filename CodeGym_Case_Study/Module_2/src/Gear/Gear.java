package Gear;

import java.io.Serializable;

public abstract class Gear implements Serializable {
    public static Long INDEX = 0L;
    private Long id;
    private String name;
    private String brand;
    private int quantity;
    private double price;

    public Gear() {
    }

    public Gear(String name, String brand, int quantity, double price) {
        this.id = ++INDEX;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Gear{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public abstract String description();
}
