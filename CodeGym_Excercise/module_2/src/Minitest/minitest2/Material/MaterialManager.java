package Minitest.minitest2.Material;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MaterialManager {
    static ArrayList<Material> materials;
    public static void main(String[] args) {
        Material crispyFlour1 = new CrispyFlour("1", "flour1", LocalDate.of(2022, 12, 10), 10, 2);
        Material crispyFlour2 = new CrispyFlour("2", "flour2", LocalDate.of(2022, 6, 10), 11, 2);
        Material crispyFlour3 = new CrispyFlour("3", "flour3", LocalDate.of(2021, 12, 10), 10, 5);
        Material crispyFlour4 = new CrispyFlour("4", "flour4", LocalDate.of(2022, 8, 10), 13, 2);
        Material crispyFlour5 = new CrispyFlour("5", "flour5", LocalDate.of(2022, 9, 10), 10, 8);
        Material meat1 = new Meat("6", "meat1", LocalDate.of(2022, 10, 15), 10, 8);
        Material meat2 = new Meat("8", "meat2", LocalDate.of(2022, 10, 19), 102, 2);
        Material meat3 = new Meat("9", "meat3", LocalDate.of(2022, 10, 20), 111, 2);
        Material meat4 = new Meat("7", "meat4", LocalDate.of(2022, 10, 21), 101, 5);
        Material meat5 = new Meat("10", "meat5", LocalDate.of(2022, 10, 22), 136, 2);
        materials = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        materials.add(crispyFlour1);
        materials.add(crispyFlour2);
        materials.add(crispyFlour3);
        materials.add(crispyFlour4);
        materials.add(crispyFlour5);
        materials.add(meat1);
        materials.add(meat2);
        materials.add(meat3);
        materials.add(meat4);
        materials.add(meat5);
        Minitest.minitest2.Material.MaterialManager materialManager = new Minitest.minitest2.Material.MaterialManager();
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Add Material");
            System.out.println("2. Update Material");
            System.out.println("3. Delete Material");
            System.out.println("4. Display");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    int choice1 = -1;
                    while (choice1 != 0) {
                        System.out.println("Menu");
                            System.out.println("1. Add Crispy Flour");
                            System.out.println("2. Add Meat");
                            System.out.println("0. Back");
                            System.out.println("Enter your choice: ");
                            choice1 = Integer.parseInt(scanner.nextLine());
                            if (choice1 != 0) {
                                materialManager.add(choice1, scanner);
                            }
                        }
                        break;
                    case 2:
                        materialManager.updateMaterial(scanner);
                        break;
                    case 3:
                        materialManager.deleteMaterial(scanner);
                        break;
                    case 4:
                        materialManager.display();
                        break;
                }
            }

        }
        public void add(int choice, Scanner scanner){
            System.out.println("Enter ID:");
            String id = scanner.nextLine();
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter manufacturing date(dd/mm/yyyy):");
            String str = scanner.nextLine();
            String[] arr = str.split("/");
            LocalDate manufacturingDate = LocalDate.of(Integer.parseInt(arr[2]),Integer.parseInt(arr[1]),
                    Integer.parseInt(arr[0]));
            System.out.println("Enter cost:");
            int cost = Integer.parseInt(scanner.nextLine());
            if (choice == 1){
                System.out.println("Enter quantity:");
                int quantity = Integer.parseInt(scanner.nextLine());
                Material flour = new CrispyFlour(id, name, manufacturingDate, cost, quantity);
                materials.add(flour);
            }
            if (choice == 2){
                System.out.println("Enter weight:");
                int weight = Integer.parseInt(scanner.nextLine());
                Material meat = new Meat(id, name, manufacturingDate, cost, weight);
                materials.add(meat);
            }
        }

        public void display(){
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (Material material : materials) {
                if (material instanceof CrispyFlour) {
                    System.out.println("ID = " + material.getId() + "; Name Material = "
                            + material.getName() +
                            "; Manufacturing Date = " + format.format(material.getManufacturingDate()) +
                            "; Cost = " + material.getCost() + "; Quantity = " + ((CrispyFlour) material).getQuantity()+
                            "; Discount = " + ((CrispyFlour) material).getRealMoney());
                }
                if (material instanceof Meat) {
                    System.out.println("ID = " + material.getId() + "; Name Material = "
                            + material.getName() +
                            "; Manufacturing Date = " + format.format(material.getManufacturingDate()) +
                            "; Cost = " + material.getCost() + "; Weight = " + ((Meat) material).getWeight() +
                            "; Discount = " + ((Meat) material).getRealMoney());
                }
            }
        }

        public void deleteMaterial(Scanner scanner){
            System.out.println("Enter index of material you need to delete");
            int i = scanner.nextInt();
            materials.remove(i);
        }

        public void updateMaterial(Scanner scanner){
            System.out.println("Enter index of material you need to update info");
            int i =Integer.parseInt(scanner.nextLine()) ;
            System.out.println("Enter new ID:");
            String id = scanner.nextLine();
            materials.get(i).setId(id);
            System.out.println("Enter new material name:");
            String name = scanner.nextLine();
            materials.get(i).setName(name);
            System.out.println("Enter new manufacturing date(dd/mm/yyyy):");
            String date = scanner.nextLine();
            String[] arrDate = date.split("/");
            LocalDate manufacturingDate = LocalDate.of(Integer.parseInt(arrDate[2]),
                    Integer.parseInt(arrDate[1]),Integer.parseInt(arrDate[0]));
            materials.get(i).setManufacturingDate(manufacturingDate);
            System.out.println("Enter new cost:");
            int cost =Integer.parseInt(scanner.nextLine());
            materials.get(i).setCost(cost);
            if (materials.get(i) instanceof CrispyFlour){
                System.out.println("Enter new quantity:");
                int quantity =Integer.parseInt(scanner.nextLine());
                materials.get(i).setCost(quantity);
            }
            if (materials.get(i) instanceof Meat){
                System.out.println("Enter new weight:");
                int weight =Integer.parseInt(scanner.nextLine());
                materials.get(i).setCost(weight);
            }
        }
}
