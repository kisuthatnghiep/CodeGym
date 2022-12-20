package RegexAndString.ClassExample;

public class ClassExampleTest {
    public static void main(String[] args) {
        String[] validClass = {"A1111G", "C1236H", "P7928L"};
        String[] inValidClass = {"A11111G", "s1236H", "T7928L"};
        ClassExample  classExample = new ClassExample();
        for (String class1: validClass){
            System.out.println("Class " + class1 + " is valid " + classExample.validate(class1));
        }
        for (String class1: inValidClass){
            System.out.println("Class " + class1 + " is valid " + classExample.validate(class1));
        }
    }
}
