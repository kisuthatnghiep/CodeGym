package LogIn;

import java.io.Serializable;

public class Account implements Serializable {
    private String email;
    private String userName;
    private String password;


    private String role;

    public Account() {
    }

    public Account(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = "USER";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
