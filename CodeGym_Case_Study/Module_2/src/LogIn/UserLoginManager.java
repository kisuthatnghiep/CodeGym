package LogIn;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import Cart.Cart;
import IOTextFile.IOTextFile;
import System.LoginSystem;
public class UserLoginManager {

    IOTextFile ioTextFile = new IOTextFile();
    public final ArrayList<Account> accounts;
    public static ArrayList<User> users;

    public static ArrayList<Cart> carts;

    public UserLoginManager() {
        accounts = ioTextFile.readFile("D:\\Case_study2\\src\\text\\Accounts.txt");
        users = ioTextFile.readFile("D:\\Case_study2\\src\\text\\Users.txt");
        carts =ioTextFile.readFile("D:\\Case_study2\\src\\text\\Carts.txt");
        if (accounts.isEmpty()){
            Account admin = new Account("admin@gmail.com", "admin", "thanh123");
                admin.setRole("ADMIN");
                accounts.add(admin);
                User user = new User("", admin, "");
                users.add(user);
                carts.add(new Cart(user));
        }
    }

    public void register(Scanner scanner){
        String email;
        while (true) {
            try {
                System.out.println("Enter email: ");
                email = scanner.nextLine();
                boolean validate = Pattern.matches("^\\w+@\\w+(\\.\\w+)$", email);
                if (!validate) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.println("Wrong format email!");
            }
        }
        String name;
        while (true) {
            try {
            System.out.println("Enter userName: ");
            name = scanner.nextLine();
                if (name.equals("")){
                    throw new InputMismatchException();
                }
            int index = checkAccountExist(name);
            if (index == -1) {
                break;
            } else {
                System.err.println("Account already exists");
            }
        }catch (InputMismatchException e){
                System.err.println("Username not entered! Try again");
            }
        }
        while (true) {
            try {
                System.out.println("Enter password: ");
                String password = scanner.nextLine();
                if (password.equals("")) {
                    throw new InputMismatchException();
                }
                Account account = new Account(email, name, password);
                accounts.add(account);
                User user = new User("", account, "");
                users.add(user);
                Cart cart = new Cart(user);
                carts.add(cart);
                break;
            } catch (InputMismatchException e) {
                System.err.println("Password not entered! Try again");
            }
        }
        System.out.println("Register successfully!");
        ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Accounts.txt",accounts);
        ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Users.txt",users);
        ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Carts.txt",carts);
    }

    public void logIn(Scanner scanner){
        int index;
        while (true) {
            try {
                System.out.println("UserName: ");
                String name = scanner.nextLine();
                if (name.equals("")){
                    throw new InputMismatchException();
                }
                index = checkAccountExist(name);
                if (index != -1) {
                    break;
                } else {
                    System.err.println("Account not exist");
                }
            }catch (InputMismatchException e){
                System.err.println("UserName not entered! Try again");
            }
        }

        while (true) {
            try {
                System.out.println("Password: ");
                String password = scanner.nextLine();
                if (password.equals("")){
                    throw new InputMismatchException();
                }
                if (password.equals(accounts.get(index).getPassword())) {
                    if (accounts.get(index).getRole().equals("ADMIN")) {
                        users.get(index).setOn(true);
                        LoginSystem.adminMenu();
                    } else {
                        users.get(index).setOn(true);
                        LoginSystem.userMenu();
                    }
                    break;
                } else {
                    System.err.println("Wrong password");
                }
            }catch (InputMismatchException e){
                System.err.println("Password not entered! Try again");
            }
        }
    }

    private int checkAccountExist(String name){
        int index = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (name.equals(accounts.get(i).getUserName())) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public void changePassword(Scanner scanner){
        String name;
        while (true) {
            try {
                System.out.println("Enter userName:");
                name = scanner.nextLine();
                if (name.equals("")) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("UserName not entered! Try again");
            }
        }
        int index = checkAccountExist(name);
        if (index != -1){
            String oldPassword;
            while (true) {
                try {
                    System.out.println("Enter old password");
                    oldPassword = scanner.nextLine();
                    if (oldPassword.equals("")){
                        throw new InputMismatchException();
                    }
                    break;
                }catch (InputMismatchException e){
                    System.err.println("Not Enter password! Try again");
                }

            }
                if (oldPassword.equals(accounts.get(index).getPassword())) {
                    String newPassword;
                    while (true) {
                        try {
                            System.out.println("Enter new password");
                            newPassword = scanner.nextLine();
                            if (newPassword.equals("")) {
                                throw new InputMismatchException();
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.err.println("Not Enter password! Try again");
                        }
                    }
                while (true) {
                    try {
                        System.out.println("Re-enter password");
                        String authenticationPassword = scanner.nextLine();
                        if (authenticationPassword.equals("")){
                            throw new InputMismatchException();
                        }
                        if (newPassword.equals(authenticationPassword)) {
                            accounts.get(index).setPassword(newPassword);
                            System.err.println("Change password successfully");
                            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Accounts.txt",accounts);
                            users.get(index).setAccount(accounts.get(index));
                            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Users.txt",users);
                            carts.get(index).setUser(users.get(index));
                            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Carts.txt",carts);
                            break;
                        } else {
                            System.err.println("password authentication is not correct");
                        }
                    }catch (InputMismatchException e){
                        System.err.println("Not Enter password! Try again");
                    }

                }
            }else {
                    System.err.println("Wrong password");
                }
        }else {
            System.err.println("Account not exist");
        }
    }

    public static void logOut(){
        for (User user: users){
            if (user.isOn()){
                user.setOn(false);
                break;
            }
        }
    }

    public void forgotPassword(Scanner scanner){
        String name;
        while (true) {
            try {
                System.out.println("UserName:");
                name = scanner.nextLine();
                if (name.equals("")){
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("Not enter UserName!");
            }
        }
        int index = checkAccountExist(name);
        if (index != -1){
            String email;
            while (true) {
                try {
                    System.out.println("Enter the email you used to create this account:");
                    email = scanner.nextLine();
                    boolean validate = Pattern.matches("^\\w+@\\w+(\\.\\w+)$", email);
                    if (!validate) {
                        throw new Exception();
                    }
                    break;
                }catch (Exception e){
                    System.err.println("Wrong format email!");
                }

            }
            if (email.equals(accounts.get(index).getEmail())){
                String password;
                while (true){
                    try {
                        System.out.println("Enter new password");
                        password = scanner.nextLine();
                        if (password.equals("")){
                            throw new InputMismatchException();
                        }
                        break;
                    }catch (InputMismatchException e){
                        System.err.println("Not Enter password! Try again");
                    }
                }
                while (true) {
                    try {
                        System.out.println("Re-enter password");
                        String authenticationPassword = scanner.nextLine();
                        if (authenticationPassword.equals("")){
                            throw new InputMismatchException();
                        }
                        if (password.equals(authenticationPassword)) {
                            accounts.get(index).setPassword(password);
                            System.err.println("Change password successfully");
                            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Accounts.txt",accounts);
                            users.get(index).setAccount(accounts.get(index));
                            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Users.txt",users);
                            carts.get(index).setUser(users.get(index));
                            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Carts.txt",carts);
                            break;
                        } else {
                            System.err.println("password authentication is not correct");
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Not enter password! Try again");
                    }
                    }
            }else {
                System.err.println("Wrong email");
            }
        }else {
            System.err.println("Account not exist");
        }
    }
}

