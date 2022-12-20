package introduction;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        int d = number % 100;
        String num0 = "";
        String num1 = "";
        String num2 = "";
        String num;
        if (number >= 100){
            int c = number / 100;

            switch (c){
                case 1:
                    num0 += "one";
                    break;
                case 2:
                    num0 += "two";
                    break;
                case 3:
                    num0 += "three";
                    break;
                case 4:
                    num0 += "four";
                    break;
                case 5:
                    num0 += "five";
                    break;
                case 6:
                    num0 += "six";
                    break;
                case 7:
                    num0 += "seven";
                    break;
                case 8:
                    num0 += "eight";
                    break;
                case 9:
                    num0 += "nine";
                    break;
            }
            num0 += " hundred";
            if (d !=0){
                num0 += " and ";
            }
        }

            int a = d / 10;
            int b = d % 10;
            if (a != 1) {
                switch (a) {
                    case 2:
                        num1 += "twenty ";
                        break;
                    case 3:
                        num1 += "thirty ";
                        break;
                    case 4:
                        num1 += "forty ";
                        break;
                    case 5:
                        num1 += "fifty ";
                        break;
                    case 6:
                        num1 += "sixty ";
                        break;
                    case 7:
                        num1 += "seventy ";
                        break;
                    case 8:
                        num1 += "eighty ";
                        break;
                    case 9:
                        num1 += "ninety ";
                        break;
                    default:
                        break;
                }

                switch (b) {
                    case 1:
                        num2 += "one";
                        break;
                    case 2:
                        num2 += "two";
                        break;
                    case 3:
                        num2 += "three";
                        break;
                    case 4:
                        num2 += "four";
                        break;
                    case 5:
                        num2 += "five";
                        break;
                    case 6:
                        num2 += "six";
                        break;
                    case 7:
                        num2 += "seven";
                        break;
                    case 8:
                        num2 += "eight";
                        break;
                    case 9:
                        num2 += "nine";
                        break;
                    default:
                        break;
                }
            } else {
                switch (b) {
                    case 0:
                        num2 += "ten";
                        break;
                    case 1:
                        num2 += "eleven";
                        break;
                    case 2:
                        num2 += "twelve";
                        break;
                    case 3:
                        num2 += "thirteen";
                        break;
                    case 4:
                        num2 += "fourteen";
                        break;
                    case 5:
                        num2 += "fifteen";
                        break;
                    case 6:
                        num2 += "sixteen";
                        break;
                    case 7:
                        num2 += "seventeen";
                        break;
                    case 8:
                        num2 += "eighteen";
                        break;
                    case 9:
                        num2 += "nineteen";
                        break;
                    default:
                        break;
                }
            }

        num =num0+ num1 + num2;
        System.out.println(num);
        if (number == 0)
            System.out.println("zero");
    }
    }

