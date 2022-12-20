package Thread.NumberGenerator;

public class NumberGenerator implements Runnable{
    private final Thread myThread;

    public Thread getMyThread() {
        return myThread;
    }

    public NumberGenerator() {
        myThread = new Thread("My runnable thread");
        System.out.println("My thread created " + myThread);
        System.out.println(hashCode());
    }

    @Override
    public void run() {
try {
    for (int i = 0; i < 10; i++){
        System.out.println(i);
        Thread.sleep(500);
    }
}catch (InterruptedException e){
    System.out.println("My thread is interrupted");
}
        System.out.println("My thread run is over");
    }
}
