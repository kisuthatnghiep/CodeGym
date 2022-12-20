package Thread.RunnableDemo;

public class RunnableDemo implements Runnable{
    private Thread t;
    private final String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
    try {
    for (int i = 4; i > 0; i--){
        System.out.println("thread " + threadName + ", " + i);
        Thread.sleep(50);
    }
    }catch (InterruptedException e){
        System.out.println("Thread " + threadName + " interrupt");
    }
        System.out.println("Thread " + threadName + " exiting");
    }

    public void start(){
        System.out.println("Thread " + threadName + " start");
        if (t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
