package System;

import Cart.CartManager;
import Gear.GearManagerByAdm;
import Gear.GearManagerByUser;
import LogIn.UserLoginManager;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginSystem {
private static Scanner scanner;
private final UserLoginManager userLoginManager;

    public LoginSystem() {
        scanner = new Scanner(System.in);
        this.userLoginManager = new UserLoginManager();
        GearManagerByAdm gearManagerByAdm = new GearManagerByAdm();
    }

    public void menuLogIn(){
        int choice = -1;
        while (choice != 0){
            try {
                System.out.println("Log In Menu");
                System.out.println("1. Log in");
                System.out.println("2. Register");
                System.out.println("3. Change password");
                System.out.println("4. Forgot password");
                System.out.println("0. Exit");
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        userLoginManager.logIn(scanner);
                        break;
                    case 2:
                        userLoginManager.register(scanner);
                        break;
                    case 3:
                        userLoginManager.changePassword(scanner);
                        break;
                    case 4:
                        userLoginManager.forgotPassword(scanner);
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        throw new NumberFormatException();
                }
            }catch (NumberFormatException | InputMismatchException e){
                System.err.println("Wrong format input! Try again");
            }
        }
    }


    public static void userMenu() {
        int choice;
        while (true) {
            try {
                System.out.println("User Menu");
                System.out.println("1. Update personal information");
                System.out.println("2. Display your information");
                System.out.println("3. Display gear");
                System.out.println("4. Sort by price");
                System.out.println("5. Filter by brand");
                System.out.println("6. Sort by ID");
                System.out.println("7. Search by gear name");
                System.out.println("8. Cart");
                System.out.println("9. Cart checkout");
                System.out.println("10. Recharge");
                System.out.println("11. Transaction history");
                System.out.println("0. Log out");
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                boolean validate = Pattern.matches("^\\b([0-9]|10|11)\\b$", String.valueOf(choice));
                if (!validate){
                    throw new NumberFormatException();
                }
                switch (choice){
                    case 1:
                        GearManagerByUser.updateInfo(scanner);
                        break;
                    case 2:
                        GearManagerByUser.displayInfo();
                        break;
                    case 3:
                        GearManagerByAdm.display();
                        break;
                    case 4:
                        GearManagerByUser.sortByPrice();
                        break;
                    case 5:
                        GearManagerByUser.filterByBrand(scanner);
                        break;
                    case 6:
                        GearManagerByUser.sortById();
                        break;
                    case 7:
                        GearManagerByUser.searchByName(scanner);
                        break;
                    case 8:
                        menuCart();
                        break;
                    case 9:
                        CartManager.cartCheckOut();
                        break;
                    case 10:
                        GearManagerByUser.recharge(scanner);
                        break;
                    case 11:
                        CartManager.transactionHistory();
                        break;
                }
                if (choice == 0){
                    UserLoginManager.logOut();
                    break;
                }
            }catch (NumberFormatException | InputMismatchException e){
                System.err.println("Wrong format input! Try again");
            }
        }
    }

    public static void adminMenu(){
        int choice;
        while (true) {
            try {
                System.out.println("Admin Menu");
                System.out.println("1. Add gear");
                System.out.println("2. Update gear");
                System.out.println("3. Delete gear");
                System.out.println("4. Display gear");
                System.out.println("5. Display user");
                System.out.println("0. Log out");
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                boolean validate = Pattern.matches("^[0-5]$", String.valueOf(choice));
                if (!validate){
                    throw new NumberFormatException();
                }
                switch (choice){
                    case 1:
                        menuAddGear();
                        break;
                    case 2:
                        try {
                        System.out.println("Enter ID of gear you want to update");
                        Long id1 = Long.parseLong(scanner.nextLine());
                        GearManagerByAdm.update(id1, scanner);
                        break;
                    }catch (Exception e){
                            System.err.println("Wrong format input!");
                            break;
                    }
                    case 3:
                        try {
                            System.out.println("Enter ID of gear you want to delete");
                            Long id2 = Long.parseLong(scanner.nextLine());
                            GearManagerByAdm.delete(id2);
                            break;
                        }catch (Exception e){
                            System.err.println("Wrong format input!");
                            break;
                        }
                    case 4:
                        GearManagerByAdm.display();
                        break;
                    case 5:
                        GearManagerByAdm.displayUser();
                        break;
                }
                if (choice == 0){
                    UserLoginManager.logOut();
                    break;
                }
            }catch (NumberFormatException | InputMismatchException e){
                System.err.println("Wrong format input! Try again");
            }
        }
    }

    public static void menuAddGear() {
        int choice = -1;
        while (choice != 0) {
            try {
                System.out.println("Menu");
                System.out.println("1. Add screen");
                System.out.println("2. Add headphone");
                System.out.println("0. Back");
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                boolean validate = Pattern.matches("^[0-2]$", String.valueOf(choice));
                if (!validate){
                    throw new NumberFormatException();
                }
                if (choice != 0) {
                    GearManagerByAdm.addGear(choice, scanner);
                }
            }catch (NumberFormatException | InputMismatchException e){
                System.err.println("Wrong format input! Try again");
            }
        }
    }

    public static void menuCart(){
        int choice = -1;
        while (choice != 0){
            try {
                System.out.println("Cart menu");
                System.out.println("1. Add to cart");
                System.out.println("2. Update cart");
                System.out.println("3. Delete gear from cart");
                System.out.println("4. Display cart");
                System.out.println("5. Display gear");
                System.out.println("0. Back");
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                boolean validate = Pattern.matches("^[0-5]$", String.valueOf(choice));
                if (!validate){
                    throw new NumberFormatException();
                }
                switch (choice){
                    case 1:
                        CartManager.addToCart(scanner);
                        break;
                    case 2:
                        CartManager.update(scanner);
                        break;
                    case 3:
                        CartManager.delete(scanner);
                        break;
                    case 4:
                        CartManager.displayCart();
                        break;
                    case 5:
                        GearManagerByAdm.display();
                        break;
                }
            }catch (NumberFormatException | InputMismatchException e){
                System.err.println("Wrong format input! Try again");
            }
        }
    }
}
