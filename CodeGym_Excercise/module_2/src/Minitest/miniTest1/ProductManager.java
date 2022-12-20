package Minitest.miniTest1;

import java.util.Objects;
import java.util.Scanner;

public class ProductManager {

        private final Product[] product = new Product[50];

        public void addProduct(){
            Product.count++;
            Scanner scanner = new Scanner(System.in);
            System.out.println("What item:");
            String name = scanner.nextLine();
            System.out.println("Price(USD): ");
            int price =Integer.parseInt(scanner.nextLine()) ;
            System.out.println("Description: ");
            String description = scanner.nextLine();
            Product product1 = new Product(name,price,description);
            this.product[Product.count] = product1;
    }
    public  void displayProduct() {
        System.out.printf("%-20s%-20s%-20s%s","Product No","Name Item","Price(USD)","Description");
        for (int i = 0; i < product.length;i++) {
            if (Objects.isNull(product[i])) {
                break;
            }
            System.out.printf("\n%-20d%-20s%-20d%s",i+1, product[i].getName(), product[i].getPrice(), product[i].getDescription());
        }
        System.out.println("\n");
        }
        public void updateProduct(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose Product.No you want to update: ");
            int productIndex = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Set name: ");
            product[productIndex-1].setName(scanner.nextLine());
            System.out.println("Set price: ");
            product[productIndex-1].setPrice(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Set description: ");
            product[productIndex-1].setDescription(scanner.nextLine());
        }
        public void deleteProduct(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose Product.No you want to delete: ");
            int productIndex = scanner.nextInt();
            scanner.nextLine();
            for (int j = productIndex-1; j < product.length-1; j++){
                product[j]=product[j+1];
            }
            product[product.length-1]=null;
        }
        public void displayMaxPriceProduct(){
            int index = 0;
            int max = 0;
            for(int i = 0; i < product.length;i++){
                if(Objects.isNull(product[i])) {
                    break;
                }
                if(max < product[i].getPrice()){
                    max = product[i].getPrice();
                    index = i;
                }

            }
            System.out.println("the product with the highest price is: "+product[index].getName());
            System.out.println(" has price "+product[index].getPrice());
        }
    }

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Add product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("4. Display product");
            System.out.println("5. Display max price product");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.updateProduct();
                    break;
                case 3:
                    productManager.deleteProduct();
                    break;
                case 4:
                    productManager.displayProduct();
                    break;
                case 5:
                    productManager.displayMaxPriceProduct();
                    break;
            }
        }
    }
}