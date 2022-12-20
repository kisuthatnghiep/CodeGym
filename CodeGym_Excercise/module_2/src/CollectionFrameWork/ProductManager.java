package CollectionFrameWork;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<>();
    public void addProduct(Scanner scanner){
        System.out.println("Add product:");
        System.out.println("Input a name:");
        String name = scanner.nextLine();
        System.out.println("Input price:");
        int price=Integer.parseInt(scanner.nextLine()) ;
        System.out.println("Input description:");
        String description = scanner.nextLine();
        Product product = new Product(name, price, description);
        products.add(product);
    }

    public void updateProduct(Scanner scanner){
        System.out.println("Update product:");
        System.out.println("Input product need to update");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println("Set name:");
        products.get(index).setName(scanner.nextLine());
        System.out.println("Set price:");
        products.get(index).setPrice(Integer.parseInt(scanner.nextLine()));
        System.out.println("Set description:");
        products.get(index).setDescription(scanner.nextLine());
    }

    public void deleteProduct(Scanner scanner){
        System.out.println("Delete product:");
        System.out.println("Input product need to delete:");
        int index = Integer.parseInt(scanner.nextLine());
        products.remove(index);
    }

    public void display(){
        for(Product product: products){
            System.out.println(product.toString());
        }
    }

    public void searchProduct(Scanner scanner){
        int indexSearch = 0;
        boolean flag = false;
        System.out.println("Search product");
        System.out.println("Enter name product need to search");
        String name = scanner.nextLine();
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getName().equals(name)){
                indexSearch = i;
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println(products.get(indexSearch).toString());
        }else {
            System.out.println("Not found product");
        }
    }

    public void sortProductPriceUp(){
        SortProductPriceUp sortProductPriceUp = new SortProductPriceUp();
        products.sort(sortProductPriceUp);
    }

    public void sortProductPriceDown(){
        SortProductPriceDown sortProductPriceDown = new SortProductPriceDown();
        products.sort(sortProductPriceDown);
    }
}

class SortProductPriceUp implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}

class SortProductPriceDown implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o2.getPrice(), o1.getPrice());
    }
}

class Main3{
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
            System.out.println("6. Sort price up product");
            System.out.println("7. Sort price down product");
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
                case 6:
                    productManager.sortProductPriceUp();
                    break;
                case 7:
                    productManager.sortProductPriceDown();
                    break;
            }
        }
    }
}