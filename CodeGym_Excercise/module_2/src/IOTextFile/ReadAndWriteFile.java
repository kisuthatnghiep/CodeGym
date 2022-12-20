package IOTextFile;
import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteFile {
    public ArrayList<Integer> readFile(String filePath){
    ArrayList<Integer> numbers = new ArrayList<>();
    try {
        File file = new File(filePath);
        if (!file.exists()){
            throw new FileNotFoundException();
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
            numbers.add(Integer.parseInt(line));
        }
        br.close();
    }catch (Exception e){
        System.err.println("File not found or format error!");
    }
    return numbers;
    }

    public void writeFile(String filePath, int max){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
            bw.write("\nMax of array list is " + max);
            bw.write("\n----------------------------");
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int findMax(ArrayList<Integer> numbers){
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        ArrayList<Integer> numbers = readAndWriteFile.readFile("D:\\module2\\text\\numbers.txt");
        int max = readAndWriteFile.findMax(numbers);
        readAndWriteFile.writeFile("D:\\module2\\text\\result.txt", max);
    }
}
