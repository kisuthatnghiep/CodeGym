package Cart;

import Gear.Gear;
import LogIn.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
    private User user;
    private Map<Gear, Integer> cartItems;
    private Map<Gear, Integer> bill;

    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
        cartItems = new HashMap<>();
        bill = new HashMap<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Gear, Integer> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Gear, Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public Map<Gear, Integer> getBill() {
        return bill;
    }

    public void setBill(Map<Gear, Integer> bill) {
        this.bill = bill;
    }
}
