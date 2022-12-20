package StackAndQueue;

import java.util.LinkedList;

public class ReverseString {
    public static void main(String[] args) {
        LinkedList<Character> wStack = new LinkedList<>();
        String mWord = "abcxyz";
        LinkedList<Character> newWStack = new LinkedList<>();
        StringBuilder s = new StringBuilder();
        for(int i =0; i < mWord.length(); i++){
            wStack.push(mWord.charAt(i));
        }
        for(int i =0; i < mWord.length(); i++) {
            newWStack.push(wStack.pop());
            s.append(newWStack.get(0));
        }
        System.out.println(s);
    }
}
