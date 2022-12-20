package Gear;

public class HeadPhone extends Gear{

    private String connection;

    public HeadPhone() {
    }

    public HeadPhone(String name, String brand,String connection, int quantity, double price) {
        super(name, brand, quantity, price);
        this.connection = connection;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    @Override
    public String description() {
        return "Headphone{Name: " + getName() + ", brand: " + getBrand() + ", connection: "
                + getConnection() + ", price = " + getPrice() + ", quantity: " + getQuantity() + "}";
    }
}
