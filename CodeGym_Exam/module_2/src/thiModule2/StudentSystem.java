package thiModule2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentSystem {
    private final StudentManager studentManager ;
    private final Scanner scanner;

    public StudentSystem() {
        this.studentManager = new StudentManager();
        this.scanner = new Scanner(System.in);
    }
    public void menuStudentManager(){
        int choice = -1;
        while (choice != 8){
            try {
                System.out.println("---- STUDENT MANAGEMENT PROGRAM ----");
                System.out.println("Select function by number (to continue)");
                System.out.println("1. View student list");
                System.out.println("2. Add");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Sort");
                System.out.println("6. Read file");
                System.out.println("7. Write file");
                System.out.println("8. Quit");
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                boolean validate = Pattern.matches("^[1-8]$", String.valueOf(choice));
                if (!validate){
                    throw new NumberFormatException();
                }
                switch (choice){
                    case 1:
                        studentManager.display();
                        break;
                    case 2:
                        studentManager.add(scanner);
                        break;
                    case 3:
                        studentManager.update(scanner);
                        break;
                    case 4:
                        studentManager.delete(scanner);
                        break;
                    case 5:
                        menuSort();
                        break;
                    case 6:
                        studentManager.readFile(scanner);
                        break;
                    case 7:
                        studentManager.writeFile();
                        break;
                }
            }catch (NumberFormatException | InputMismatchException e){
                System.err.println("Wrong format input! Try again");
            }
        }
    }

    private void menuSort() {
        int choice = -1;
        while (choice != 3) {
            try {
                System.out.println("---- Sort students by GPA ----");
                System.out.println("Select function by number (to continue)");
                System.out.println("1. Sort grade point average in ascending");
                System.out.println("2. Sort grade point average in descending");
                System.out.println("3. Back");
                choice = Integer.parseInt(scanner.nextLine());
                boolean validate = Pattern.matches("^[1-3]$", String.valueOf(choice));
                if (!validate){
                    throw new NumberFormatException();
                }
                switch (choice) {
                    case 1:
                        studentManager.sortAvgUp();
                        break;
                    case 2:
                        studentManager.sortAvgDown();
                        break;
                }
            }catch (NumberFormatException | InputMismatchException e){
                System.err.println("Wrong format input! Try again");
            }
        }
    }
}
