package Cart;

import Gear.Gear;
import Gear.GearManagerByAdm;
import Gear.GearManagerByUser;
import IOTextFile.IOTextFile;
import LogIn.UserLoginManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class CartManager {
    static IOTextFile ioTextFile = new IOTextFile();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void addToCart(Scanner scanner) {
        try {
            System.out.println("Enter the ID of the gear you want to add:");
            int id = Integer.parseInt(scanner.nextLine());
            int indexGear = GearManagerByUser.searchByID(id);
            if (indexGear != -1) {
                System.out.println("Enter quantity:");
                int quantity = Integer.parseInt(scanner.nextLine());
                int indexUser = GearManagerByUser.checkOn();
                Set<Gear> keyGear = UserLoginManager.carts.get(indexUser).getCartItems().keySet();
                boolean flag = false;
                for (Gear gear : keyGear) {
                    if (gear.getName().equals(GearManagerByAdm.gears.get(indexGear).getName())) {
                        flag = true;
                        if ((quantity + UserLoginManager.carts.get(indexUser).getCartItems().get(gear))
                                <= GearManagerByAdm.gears.get(indexGear).getQuantity()) {
                            UserLoginManager.carts.get(indexUser).getCartItems().put(GearManagerByAdm.gears.get(indexGear)
                                    , (quantity + UserLoginManager.carts.get(indexUser).getCartItems().get(gear)));
                        } else {
                            System.err.println("Exceed the quantity in the shop!");
                        }
                        break;
                    }
                }
                if (!flag) {
                    if (quantity <= GearManagerByAdm.gears.get(indexGear).getQuantity()) {
                        UserLoginManager.carts.get(indexUser).getCartItems().put(GearManagerByAdm.gears.get(indexGear), quantity);
                    } else {
                        System.err.println("Exceed the quantity in the shop!");
                    }
                }
                ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Carts.txt", UserLoginManager.carts);
            } else {
                System.err.println("Gear not exist!");
            }
        } catch (Exception e) {
            System.err.println("Wrong input");
        }
    }

    public static void displayCart() {
        int indexUser = GearManagerByUser.checkOn();
        Set<Gear> keyGear = UserLoginManager.carts.get(indexUser).getCartItems().keySet();
        if (keyGear.isEmpty()) {
            System.err.println("Cart is empty");
        } else {
            for (Gear gear : keyGear) {
                System.out.println(gear.toString() + ", quantity: "
                        + UserLoginManager.carts.get(indexUser).getCartItems().get(gear));
            }
        }
    }

    public static void delete(Scanner scanner) {
        try {
            boolean flag = false;
            int indexUser = GearManagerByUser.checkOn();
            System.out.println("Enter the ID of the gear you want to delete:");
            int id = Integer.parseInt(scanner.nextLine());
            Set<Gear> keyGear = UserLoginManager.carts.get(indexUser).getCartItems().keySet();
            for (Gear gear : keyGear) {
                if (gear.getId() == id) {
                    flag = true;
                    UserLoginManager.carts.get(indexUser).getCartItems().remove(gear);
                    break;
                }
            }
            if (!flag) {
                System.err.println("This gear is not in the cart!");
            }
            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Carts.txt", UserLoginManager.carts);
        } catch (Exception e) {
            System.err.println("Wrong input");
        }
    }

    public static void update(Scanner scanner) {
        try {
            boolean flag = false;
            int indexUser = GearManagerByUser.checkOn();
            System.out.println("Enter the ID of the gear you want to delete:");
            int id = Integer.parseInt(scanner.nextLine());
            Set<Gear> keyGear = UserLoginManager.carts.get(indexUser).getCartItems().keySet();
            for (Gear gear : keyGear) {
                if (gear.getId() == id) {
                    flag = true;
                    System.out.println("Enter new quantity:");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    int indexGear = GearManagerByUser.searchByID(id);
                    if (quantity <= GearManagerByAdm.gears.get(indexGear).getQuantity()) {
                        UserLoginManager.carts.get(indexUser).getCartItems().put(GearManagerByAdm.gears.get(indexGear), quantity);
                    } else {
                        System.err.println("Exceed the quantity in the shop!");
                    }
                    break;
                }
            }
            if (!flag) {
                System.err.println("This gear is not in the cart!");
            }
            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Carts.txt", UserLoginManager.carts);
        } catch (Exception e) {
            System.err.println("Wrong input");
        }
    }

    public static void cartCheckOut() {
        long sum = 0;
        int indexUser = GearManagerByUser.checkOn();
        Set<Gear> keyGear = UserLoginManager.carts.get(indexUser).getCartItems().keySet();
        for (Gear gear : keyGear) {
            sum += gear.getPrice() * UserLoginManager.carts.get(indexUser).getCartItems().get(gear);
        }
        if (sum <= UserLoginManager.users.get(indexUser).getWallet()) {
            UserLoginManager.users.get(indexUser).setWallet(UserLoginManager.users.get(indexUser).getWallet() - sum);
            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Users.txt", UserLoginManager.users);
            UserLoginManager.carts.get(indexUser).setUser(UserLoginManager.users.get(indexUser));
            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Carts.txt", UserLoginManager.carts);
            UserLoginManager.carts.get(indexUser).getBill().putAll(UserLoginManager.carts.get(indexUser).getCartItems());
            UserLoginManager.carts.get(indexUser).getCartItems().clear();
            Set<Gear> gears = UserLoginManager.carts.get(indexUser).getBill().keySet();
            stringBuilder.append(UserLoginManager.carts.get(indexUser).getUser().toString());
            stringBuilder.append("\n").append(displayTime());
            for (Gear gear : gears) {
                GearManagerByAdm.gears.get(GearManagerByUser.searchByID(gear.getId().intValue()))
                        .setQuantity(GearManagerByAdm.gears
                                .get(GearManagerByUser.searchByID(gear.getId().intValue())).getQuantity() -
                                UserLoginManager.carts.get(indexUser).getBill().get(gear));
                stringBuilder.append("\n").append(gear).append(", quantity: ").
                        append(UserLoginManager.carts.get(indexUser).getBill().get(gear));
            }
            stringBuilder.append("\nPrice: ").append(sum).append("(VNĐ)")
                    .append("\n").append("-------------------------------\n");
            String userName = UserLoginManager.carts.get(indexUser).getUser().getAccount().getUserName();
            ioTextFile.writeFile("D:\\Case_study2\\src\\text\\" + userName + "Bills.txt", stringBuilder);
            System.out.println(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
            UserLoginManager.carts.get(indexUser).getBill().clear();
            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Carts.txt", UserLoginManager.carts);
            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Gears.txt", GearManagerByAdm.gears);
        } else {
            System.err.println("wallet not enough money");
        }
    }

    public static String displayTime() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(date);
    }

    public static void transactionHistory() {
        int indexUser = GearManagerByUser.checkOn();
        String userName = UserLoginManager.carts.get(indexUser).getUser().getAccount().getUserName();
        ioTextFile.readFileText("D:\\Case_study2\\src\\text\\" + userName + "Bills.txt");
    }
}
