package loop;

public class Prime3 {
    public static void main(String[] args) {

        int number = 2;
        System.out.println("Các số nguyên tố nhỏ hơn 100 là: ");
        while (number < 100) {
            boolean flag =true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(number+" ");
            }
            number++;
        }
    }
}
