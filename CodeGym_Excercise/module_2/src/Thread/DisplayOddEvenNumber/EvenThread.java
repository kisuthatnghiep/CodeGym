package Thread.DisplayOddEvenNumber;

public class EvenThread extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 2; i <= 10; i += 2){
                System.out.println("Even number: " + i);
                Thread.sleep(15);
            }
        }catch (InterruptedException e){
            System.out.println("Thread interrupted");
        }

    }
}
