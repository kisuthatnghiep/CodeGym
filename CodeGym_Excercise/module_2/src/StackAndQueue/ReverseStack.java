package StackAndQueue;
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Double> stack = new Stack<>();
        double[] arr ={1,2,3,3.5,4,6,6.8};
        for (double number: arr){
            stack.push(number);
        }
        for (int i = 0; i < arr.length; i++){
            arr[i] = stack.pop();
        }
    }
}
