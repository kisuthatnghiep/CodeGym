package Gear;

import IOTextFile.IOTextFile;
import LogIn.UserLoginManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GearManagerByAdm {

    static IOTextFile ioTextFile = new IOTextFile();
    static UserLoginManager userLoginManager = new UserLoginManager();
    public static ArrayList<Gear> gears;

    public GearManagerByAdm() {
        gears = ioTextFile.readFile("D:\\Case_study2\\src\\text\\Gears.txt");
        resetStaticIndex();
    }

    private void resetStaticIndex() {
        if (!gears.isEmpty()) {
            Gear.INDEX = gears.get(gears.size() - 1).getId();
        }
    }

    public static void addGear(int choice, Scanner scanner) {
        String gear;
        String brand;
        String quantity;
        String price;
        while (true) {
            System.out.println("Enter name gear: ");
            gear = scanner.nextLine();
            boolean validate = Pattern.matches("^\\w+[\\s\\w]*$", String.valueOf(gear));
            if (validate) {
                break;
            } else {
                System.out.println("Wrong format input!");
            }
        }
        while (true) {
            System.out.println("Enter brand: ");
            brand = scanner.nextLine();
            boolean validate = Pattern.matches("^\\w+[\\s\\w]*$", String.valueOf(brand));
            if (validate) {
                break;
            } else {
                System.out.println("Wrong format input!");
            }
        }
        while (true) {
            System.out.println("Enter quantity: ");
            quantity = scanner.nextLine();
            boolean validate = Pattern.matches("^\\d+$", quantity);
            if (validate) {
                break;
            } else {
                System.out.println("Wrong format input!");
            }
        }
        while (true) {
            System.out.println("Enter price(VNĐ): ");
            price = scanner.nextLine();
            boolean validate = Pattern.matches("^\\d+$", price);
            if (validate) {
                break;
            } else {
                System.out.println("Wrong format input!");
            }
        }
        if (choice == 1) {
            String frequency;
            while (true) {
                System.out.println("Enter sweep frequency(Hz): ");
                frequency = scanner.nextLine();
                boolean validate = Pattern.matches("^\\d+$", frequency);
                if (validate) {
                    break;
                } else {
                    System.out.println("Wrong format input!");
                }
            }
            gears.add(new Screen(gear, brand, Integer.parseInt(quantity), Double.parseDouble(price), Integer.parseInt(frequency)));

        }
        if (choice == 2) {
            String connection;
            while (true) {
                System.out.println("Enter connection type");
                connection = scanner.nextLine();
                boolean validate = Pattern.matches("^\\w+[\\s\\w]*$", connection);
                if (validate) {
                    break;
                } else {
                    System.out.println("Wrong format input!");
                }
            }
            gears.add(new HeadPhone(gear, brand, connection, Integer.parseInt(quantity), Double.parseDouble(price)));
        }
        ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Gears.txt", gears);
    }

    public static void display() {
        if (gears.isEmpty()) {
            System.out.println("No gear available");
        } else {
            System.err.printf("%-10s%-45s%-20s%-25s%-20s%-20s%s", "ID", "Name", "Brand", "Sweep frequency(Hz)",
                    "Connection", "Price(VNĐ)", "Quantity");
            for (Gear gear : gears) {
                if (gear instanceof Screen) {
                    System.out.printf("\n%-10d%-45s%-20s%-25d%-20s%-20.0f%d", gear.getId(),
                            gear.getName(), gear.getBrand(), ((Screen) gear).getSweepFrequency(),
                            "", gear.getPrice(), gear.getQuantity());
                }
                if (gear instanceof HeadPhone) {
                    System.out.printf("\n%-10d%-45s%-20s%-25s%-20s%-20.0f%d", gear.getId(),
                            gear.getName(), gear.getBrand(), "",
                            ((HeadPhone) gear).getConnection(), gear.getPrice(), gear.getQuantity());
                }
            }
            System.out.println("\n");
        }
    }

    public static void delete(Long id) {
        boolean flag = false;
        for (Gear gear : gears) {
            if (Objects.equals(gear.getId(), id)) {
                gears.remove(gear);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.err.println("Not exist this ID!");
        }
        ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Gears.txt", gears);
    }

    public static void update(Long id, Scanner scanner) {
        boolean flag = false;
        for (Gear gear : gears) {
            if (Objects.equals(gear.getId(), id)) {
                flag = true;
                System.out.println("Enter new name gear: ");
                String name = scanner.nextLine();
                if (!name.equals("")) {
                    gear.setName(name);
                }
                System.out.println("Enter new brand:");
                String brand = scanner.nextLine();
                if (!brand.equals("")) {
                    gear.setBrand(brand);
                }
                if (gear instanceof Screen) {
                    String frequency;
                    while (true) {
                        System.out.println("Enter new sweep frequency: ");
                        frequency = scanner.nextLine();
                        if (frequency.equals("")){
                            break;
                        }
                        boolean validate = Pattern.matches("^\\d+$", frequency);
                        if (validate) {
                            ((Screen) gear).setSweepFrequency(Integer.parseInt(frequency));
                            break;
                        } else {
                            System.out.println("Wrong format input!");
                        }
                    }
                }
                if (gear instanceof HeadPhone) {
                    System.out.println("Enter new connection type: ");
                    String connection = scanner.nextLine();
                    if (!connection.equals("")) {
                        ((HeadPhone) gear).setConnection(connection);
                    }
                }
                String price;
                while (true) {
                    System.out.println("Enter new price: ");
                    price = scanner.nextLine();
                    if (price.equals("")){
                        break;
                    }
                    boolean validate = Pattern.matches("^\\d+$", price);
                    if (validate) {
                        gear.setPrice(Integer.parseInt(price));
                        break;
                    } else {
                        System.out.println("Wrong format input!");
                    }
                }
                String quantity;
                while (true) {
                    System.out.println("Enter new quantity: ");
                    quantity = scanner.nextLine();
                    if (quantity.equals("")){
                        break;
                    }
                    boolean validate = Pattern.matches("^\\d+$", quantity);
                    if (validate) {
                        gear.setQuantity(Integer.parseInt(quantity));
                        break;
                    } else {
                        System.out.println("Wrong format input!");
                    }
                }
                break;
            }
        }
        if (!flag) {
            System.err.println("Not exist this ID!");
        }
        ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Gears.txt", gears);
    }

    public static void displayUser() {
        System.out.printf("%-20s%-20s%-25s%-35s%-20s%s", "UserNo", "Name", "Phone number", "Email",
                "UserName", "Role");
        for (int i = 0; i < UserLoginManager.users.size(); i++) {
            System.out.printf("\n%-20d%-20s%-25s%-35s%-20s%s", i + 1, UserLoginManager.users.get(i).getName(),
                    UserLoginManager.users.get(i).getPhoneNumber(),
                    UserLoginManager.users.get(i).getAccount().getEmail(),
                    UserLoginManager.users.get(i).getAccount().getUserName(),
                    UserLoginManager.users.get(i).getAccount().getRole());
        }
        System.out.println("\n");
    }
}
