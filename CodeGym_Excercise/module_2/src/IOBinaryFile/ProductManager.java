package IOBinaryFile;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void writeToFile(String path, ArrayList<Product> products){
    try {
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
        oos.writeObject(products);
        oos.close();
    }catch (Exception e){
        e.printStackTrace();
    }
    }

    public ArrayList<Product> readFile(String path){
        ArrayList<Product> products = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(path)));
             products = (ArrayList<Product>) ois.readObject();
             ois.close();
        }catch (Exception e){
            System.out.println();
        }
        return products;
    }

    public void addProduct(Scanner scanner){
//        products = readFile("D:\\module2\\text\\products.txt");
        System.out.println("Add product:");
        System.out.println("Enter product code:");
        String code = scanner.nextLine();
        System.out.println("Input a name:");
        String name = scanner.nextLine();
        System.out.println("Input a brand");
        String brand = scanner.nextLine();
        System.out.println("Input price:");
        long price = Integer.parseInt(scanner.nextLine()) ;
        System.out.println("Enter description");
        String description = scanner.nextLine();
        Product product = new Product(code, name, brand, price, description);
        products.add(product);
        System.out.println(products);
        writeToFile("D:\\module2\\text\\products.txt", products);
    }

    public void deleteProduct(Scanner scanner){
        products = readFile("D:\\module2\\text\\products.txt");
        System.out.println("Delete product:");
        System.out.println("Input product need to delete:");
        int index = Integer.parseInt(scanner.nextLine());
        products.remove(index);
        writeToFile("D:\\module2\\text\\products.txt", products);
    }

    public void display(){
        ArrayList<Product> dataProduct = readFile("D:\\module2\\text\\products.txt");
        if (dataProduct.isEmpty()){
            System.out.println("No available product ");
        }
        for(Product product: dataProduct){
            System.out.println(product.toString());
        }
    }

    public void updateProduct(Scanner scanner){
        products = readFile("D:\\module2\\text\\products.txt");
        System.out.println("Update product:");
        System.out.println("Input product need to update");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter product code:");
        products.get(index).setProductCode(scanner.nextLine());
        System.out.println("Input a name:");
        products.get(index).setName(scanner.nextLine());
        System.out.println("Input a brand");
        products.get(index).setBrand(scanner.nextLine());
        System.out.println("Input price:");
        products.get(index).setPrice(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter description");
        products.get(index).setDescription(scanner.nextLine());
        writeToFile("D:\\module2\\text\\products.txt", products);
    }

    public void searchProduct(Scanner scanner){
        products = readFile("D:\\module2\\text\\products.txt");
        boolean flag = false;
        System.out.println("Enter name product need to search");
        String name = scanner.nextLine();
        for (Product product: products){
            if (product.getName().equals(name)){
                flag = true;
                System.out.println(product);
                break;
            }
        }
        if (!flag){
            System.out.println("can't find product");
        }
    }
}
