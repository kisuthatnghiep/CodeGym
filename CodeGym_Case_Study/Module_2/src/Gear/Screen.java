package Gear;

public class Screen extends Gear{
    private int sweepFrequency;

    public Screen() {
    }

    public Screen(String name, String brand, int quantity, double price, int sweepFrequency) {
        super(name, brand, quantity, price);
        this.sweepFrequency = sweepFrequency;
    }

    public int getSweepFrequency() {
        return sweepFrequency;
    }

    public void setSweepFrequency(int sweepFrequency) {
        this.sweepFrequency = sweepFrequency;
    }

    @Override
    public String description() {
        return "Screen{Name: " + getName() + ", brand: " + getBrand() + ", sweepFrequency: " + getSweepFrequency()
                + ", price = " + getPrice() + ", quantity: " + getQuantity() + "}";
    }
}
