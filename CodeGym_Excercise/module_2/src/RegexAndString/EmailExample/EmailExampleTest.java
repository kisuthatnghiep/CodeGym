package RegexAndString.EmailExample;

import RegexAndString.EmailExample.EmailExample;

public class EmailExampleTest {
    public static void main(String[] args) {
        EmailExample emailExample;
        String[] validEmail = {"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
        String[] inValidEmail = {"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};
        emailExample = new EmailExample();
        for (String email: validEmail){
            System.out.println("Email is " + email + " is valid " + emailExample.validate(email));
        }
        for (String email: inValidEmail){
            System.out.println("Email is " + email + " is valid " + emailExample.validate(email));
        }

    }
}
