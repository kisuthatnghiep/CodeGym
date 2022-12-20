package IOBinaryFile;


import java.util.Scanner;

public class ProductSystem {
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
            System.out.println("5. Search product");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice =Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.addProduct(scanner);
                    break;
                case 2:
                    productManager.updateProduct(scanner);
                    break;
                case 3:
                    productManager.deleteProduct(scanner);
                    break;
                case 4:
                    productManager.display();
                    break;
                case 5:
                    productManager.searchProduct(scanner);
                    break;
            }
        }
    }
}
