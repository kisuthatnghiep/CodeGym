package ClassAndObject;

public class CountTimeStopWatch {
    public static void main(String[] args) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    selectionSort();
    stopWatch.stop();
        System.out.println("Time run selectionSort: ");
        System.out.println(stopWatch.getElapsedTime());
    }
    public static void selectionSort(){
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array[i]=(int)(Math.random()*100000);
        }
        for (int i = 0; i < array.length -1; i++){
            for (int j = i+1; j < array.length; j++){
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
        }
        }
        for (int i:array){
            System.out.println(i);
        }
    }
}
