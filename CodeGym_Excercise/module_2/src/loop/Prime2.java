package loop;

public class Prime2 {
    public static void main(String[] args) {

        int count = 0;
        int number = 2;
        System.out.println("20 Số nguyên tố đầu tiên là: ");
        while (count < 20) {
            boolean flag =true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(number+" ");
                count++;
            }
            number++;
        }
    }
}
