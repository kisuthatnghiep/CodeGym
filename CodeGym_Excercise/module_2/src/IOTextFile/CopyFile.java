package IOTextFile;

import java.io.*;
import java.util.ArrayList;

public class CopyFile {
    public static void main(String[] args) {
        ArrayList<String> sourceFile = new ArrayList<>();
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader("D:\\module2\\text\\numbers.txt"));
            while ((line = br.readLine()) != null){
                System.out.println(line);
                sourceFile.add(line);
            }
            int count = 0;
            for (String str: sourceFile){
                count += str.length();
            }
            System.out.println("Source file has " + count + " character");
            br.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\module2\\text\\result.txt", true));
            for (String s : sourceFile) {
                bw.write("\n" + s);
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
