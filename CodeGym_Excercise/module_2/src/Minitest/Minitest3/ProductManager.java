package Minitest.Minitest3;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProductManager {

    private final ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    private ArrayList<Product> readFile(String path){
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

    public void writeToFile(String path, ArrayList<Product> products){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
            oos.writeObject(products);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
