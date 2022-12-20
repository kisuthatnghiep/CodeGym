package Thread.Car;

import java.util.Random;

public class Car implements Runnable{
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
     int runDistance = 0;
     long startTime = System.currentTimeMillis();
     while (runDistance < Test.DISTANCE){
         try {
             int speed = (new Random()).nextInt(20);
             runDistance += speed;
             StringBuilder log = new StringBuilder("|");
             int percentTravel = runDistance / Test.DISTANCE * 100;
             for (int i = 0; i < Test.DISTANCE; i += Test.STEP){
                 if (percentTravel >= i + Test.STEP) {
                     log.append("=");
                 } else if (percentTravel >= i && percentTravel < i + Test.STEP) {
                     log.append("o");
                 } else {
                     log.append("-");
                 }
             }
             log.append("|");
             System.out.println("Car" + this.name + ": " + log + " " + Math.min(Test.DISTANCE, runDistance) + "KM");
             Thread.sleep(500);
         }catch (InterruptedException e){
             System.out.println("Car " + this.name + " broken");
             break;
         }
     }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
