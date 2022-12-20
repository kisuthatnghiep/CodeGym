package Thread.DisplayOddEvenNumber;

public class OddThread extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 1; i < 10; i += 2){
                System.out.println("Odd number: " + i);
                Thread.sleep(10);
            }
        }catch (InterruptedException e){
            System.out.println("Thread interrupted");
        }
    }
}
