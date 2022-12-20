package LogIn;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String phoneNumber;
    private Account account;
    private long wallet;

    private boolean isOn;

    public User() {
    }

    public User(String name, Account account, String phoneNumber) {
        this.isOn = false;
        this.name = name;
        this.account = account;
        this.phoneNumber = phoneNumber;
        this.wallet = 0;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email=" + getAccount().getEmail() +
                ", userName=" + getAccount().getUserName() +
                ", role=" + getAccount().getRole() +
                ", wallet=" + getWallet() + "(VNĐ)" +
                '}';
    }
}
