import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(13);
        arr.add(3);
        arr.add(8);
        arr.add(14);
        arr.add(9);
        arr.add(4);
        arr.add(4);
        System.out.println(arr);
        List<Integer> result = new ArrayList<>();
        result.add(arr.size());
        while(arr.size() != 0){
            int a = arr.get(0);
            for(int i = 0 ; i < arr.size(); i++){
                if(a > arr.get(i)){
                    a = arr.get(i);
                }
            }
            for(int i = 0 ; i < arr.size(); i++){
                if(arr.get(i) == a){
                    arr.remove(i);
                    i--;
                }
            }
            if(arr.size() != 0){
                result.add(arr.size());
            }

        }
        for (Integer a: result){
            System.out.println(a);
        }
    }
}
