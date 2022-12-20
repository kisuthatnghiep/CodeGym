package IOBinaryFile;

import java.io.Serializable;

public class Product implements Serializable {
    private String productCode;
    private String name;
    private String brand;
    private long price;
    private String description;

    public Product() {
    }

    public Product(String productCode, String name, String brand, long price, String description) {
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{Product code = " + productCode + ", name = " + name + ", brand = " + brand + ", price = " +
                 price + ", description = " + description + "}";
    }
}
