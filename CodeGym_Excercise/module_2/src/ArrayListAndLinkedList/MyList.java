package ArrayListAndLinkedList;


import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Object[]element;

    public MyList(){
        element = new Object[DEFAULT_CAPACITY];
    }
    private void ensureCapacity(){
        int newSize = element.length * 2;
        element = Arrays.copyOf(element, newSize);
    }

    public void add(E e){
        if (size == element.length){
            ensureCapacity();
        }
        element[size++] = e;
    }

    public Object get(int i){
        return element[i];
    }
}

class MyListTest{
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(2);
        myList.add(3);
        myList.add(4);
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        System.out.println(myList.get(0));
    }
}
