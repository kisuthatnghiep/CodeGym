package ArrayAndMethod;

import java.util.Scanner;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string: ");
        String str = scanner.nextLine();
        System.out.println("Input character want to count: ");
        char character = scanner.next().charAt(0);
        int count = 0;
        for (int i =0; i < str.length(); i++){
        if (str.charAt(i) == character){
        count++;
        }
        }
        System.out.println("There are "+count+" character "+character+" in the string");
    }
}
