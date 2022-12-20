package ArrayAndMethod;

import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] student = {"thanh","dat","hanh","phuc","nam","nghia","lam","quan","thao"};
        System.out.println("Enter a name: ");
        String name = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < student.length; i++) {
            if (student[i].equals(name)) {
                System.out.println("The position of " + name + " in the list is " + i);
                flag = true;
                break;
            }
        }
           if (!flag)
               System.out.println("Not found position of "+name+" in the list");
    }
}
