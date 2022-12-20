package Thread.NumberGenerator;

public class Main {
    public static void main(String[] args) {
        NumberGenerator numberGenerator1 = new NumberGenerator();
        Thread thread1 = new Thread(numberGenerator1,"numberGenerator1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        NumberGenerator numberGenerator2 = new NumberGenerator();
        Thread thread2= new Thread(numberGenerator2, "numberGenerator2");
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.start();
    }
}
