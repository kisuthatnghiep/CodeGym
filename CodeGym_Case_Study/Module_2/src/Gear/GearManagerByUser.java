package Gear;

import IOTextFile.IOTextFile;
import LogIn.UserLoginManager;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GearManagerByUser {
    static IOTextFile ioTextFile = new IOTextFile();
    static GearManagerByAdm gearManagerByAdm = new GearManagerByAdm();

    public static void updateInfo(Scanner scanner){
        int index = checkOn();
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        if (!name.equals("")) {
            UserLoginManager.users.get(index).setName(name);
        }
        System.out.println("Enter phone number(0x-xxxxxxxxx):");
        String phone = scanner.nextLine();
        boolean validate = Pattern.matches("^\\s|((84|0[35789])+([0-9]{8})\\b)$", String.valueOf(phone));
        if (validate) {
            UserLoginManager.users.get(index).setPhoneNumber(phone);
        }else {
            System.err.println("Incorrect phone number syntax");
        }
        ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Users.txt", UserLoginManager.users);
    }

    public static void sortByPrice(){
        PriceComparator priceComparator = new PriceComparator();
        GearManagerByAdm.gears.sort(priceComparator);
        GearManagerByAdm.display();
    }

    public static void sortById(){
        IDComparator idComparator = new IDComparator();
        GearManagerByAdm.gears.sort(idComparator);
        GearManagerByAdm.display();
    }

    public static void filterByBrand(Scanner scanner){
        boolean flag = false;
        System.out.println("Enter a brand: ");
        String brand = scanner.nextLine();
        boolean validate = Pattern.matches("^\\w+$", String.valueOf(brand));
        if (validate) {
            for (Gear gear : GearManagerByAdm.gears) {
                if (gear.getBrand().equalsIgnoreCase(brand)) {
                    flag = true;
                    System.out.println(gear.description());
                }
            }
            if (!flag) {
                System.err.println("No results were found");
            }
        }else {
            System.err.println("Wrong format input!");
        }
    }

    public static void searchByName(Scanner scanner){
        boolean flag = false;
        System.out.println("Enter a name: ");
        String name = scanner.nextLine();
        boolean validate = Pattern.matches("^\\w+$", String.valueOf(name));
        if (validate) {
            for (Gear gear : GearManagerByAdm.gears) {
                if (gear.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(gear.description());
                    flag = true;
                }
            }
            if (!flag) {
                System.err.println("No results were found");
            }
        }else {
            System.err.println("Wrong format input!");
        }
    }

    public static int checkOn(){
        int index = -1;
        for (int i = 0; i < UserLoginManager.users.size(); i++){
            if (UserLoginManager.users.get(i).isOn()){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void displayInfo(){
        int index = checkOn();
        System.out.println(UserLoginManager.users.get(index).toString());
    }

    public static int searchByID(int id){
        for (int i = 0; i < GearManagerByAdm.gears.size(); i++){
            if (GearManagerByAdm.gears.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    public static void recharge(Scanner scanner){
        int indexUser = GearManagerByUser.checkOn();
        System.out.println("Enter the amount you want to deposit(VNĐ): ");
        long money = Long.parseLong(scanner.nextLine());
        boolean validate = Pattern.matches("^\\d+$", String.valueOf(money));
        if (validate) {
            UserLoginManager.users.get(indexUser).setWallet(UserLoginManager.users.get(indexUser).getWallet() + money);
            UserLoginManager.carts.get(indexUser).setUser(UserLoginManager.users.get(indexUser));
            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Users.txt", UserLoginManager.users);
            ioTextFile.writeToFile("D:\\Case_study2\\src\\text\\Carts.txt", UserLoginManager.carts);
        }else {
            System.out.println("Wrong format input!");
        }
    }
}
