package Testing;

public class FizzBuzz {
    public static String fizzBuzz(int number){
        boolean fizz = false;
        boolean buzz = false;
     if (number % 3 == 0 ||(number < 100 &&(number % 10 == 3|| number / 10 == 3))){
         fizz = true;
     }
     if (number % 5 == 0 || number < 100 && number / 10 == 5){
         buzz = true;
     }
     if (number > 0) {
         if (fizz && buzz) {
             return "FizzBuzz";
         } else if (fizz) {
             return "Fizz";
         } else if (buzz) {
             return "Buzz";
         } else
             return number + "";
     }else
            return number + "";
    }
}
