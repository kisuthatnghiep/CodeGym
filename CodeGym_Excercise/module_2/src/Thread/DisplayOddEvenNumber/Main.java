package Thread.DisplayOddEvenNumber;

public class Main {
    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();
        try {
            oddThread.start();
            oddThread.join();
            evenThread.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
