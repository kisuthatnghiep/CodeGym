package CollectionFrameWork;

import java.util.Comparator;

public class Product {
    private String name;
    private int price;
    private String Description;

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        Description = description;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String toString(){
        return "Product name = " + this.getName() + ", price = " + this.getPrice() + ", description = " + this.getDescription();
    }

}
