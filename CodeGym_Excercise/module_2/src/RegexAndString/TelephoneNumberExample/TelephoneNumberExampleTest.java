package RegexAndString.TelephoneNumberExample;

public class TelephoneNumberExampleTest {
    public static void main(String[] args) {
        String[] validPhoneNumber = {"(23)-(0123456789)", "(79)-(0123456789)"};
        String[] inValidPhoneNumber = {"(2a)-(0123456789)", "(79)-(0123a56789)", "(79)-(012356789)"};
        TelephoneNumberExample telephoneNumberExample = new TelephoneNumberExample();
        for(String phoneNumber: validPhoneNumber){
            System.out.println("Telephone number: " + phoneNumber + " is valid: " + telephoneNumberExample.validate(phoneNumber));
        }
        for(String phoneNumber: inValidPhoneNumber){
            System.out.println("Telephone number: " + phoneNumber + " is valid: " + telephoneNumberExample.validate(phoneNumber));
        }
    }
    }


