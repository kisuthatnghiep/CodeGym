package Thread.CountNumber;

public class Main {
    public static void main(String[] args) {
        Count count = new Count();
        try {
            while (count.getMyThread().isAlive()){
                System.out.println("My thread will be alive till child thread is live");
                Thread.sleep(1500);
            }
        }catch (InterruptedException e){
            System.out.println("Main thread is interrupted");
        }
        System.out.println("Main thread run is over");
    }
}
