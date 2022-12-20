package AlgolrithmSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class FindStringHighestLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = scanner.nextLine();
        highestLengthString(str);
    }

    static void highestLengthString(String str){
        ArrayList<Character> max = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            ArrayList<Character> temp = new ArrayList<>();
            temp.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++){
                if (temp.get(temp.size() - 1) < str.charAt(j)){
                    temp.add(str.charAt(j));
                }
            }
            if (temp.size() > max.size()){
                max.clear();
                max.addAll(temp);
                temp.clear();
            }
        }
            for (Character i: max){
                System.out.print(i);
            }
    }
}
