package IOTextFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class IOTextFile<T> {
    public ArrayList<T> readFile(String path){
        ArrayList<T> variables = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(path)));
            variables = (ArrayList<T>) ois.readObject();
            ois.close();
        }catch (Exception e){
            System.out.println();
        }
        return variables;
    }

    public void writeToFile(String path, ArrayList<T> variables){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
            oos.writeObject(variables);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeFile(String filePath, StringBuilder stringBuilder){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
            bw.write(stringBuilder.toString());
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void readFileText(String filePath){
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        }
        catch (Exception e){
            System.err.println("no transactions");
        }

    }
}
