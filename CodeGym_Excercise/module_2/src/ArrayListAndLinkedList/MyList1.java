package ArrayListAndLinkedList;

public class MyList1<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    public MyList1() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList1(int capacity) {
        elements = new Object[capacity];
    }

    void add(int index, E element){
        ensureCapacity(1);
    if (index >= 0 && index < elements.length){
        for (int i = size -1; i >= index; i--){
            elements[i+1] = elements[i];
        }
        elements[index] = element;
    }
        size++;
    }

    public int size(){
        return size;
    }

    public void ensureCapacity(int mincapacity){
        if (size == elements.length){
            Object[] newElements = new Object[elements.length + mincapacity];
            System.arraycopy(elements,0,newElements,0,size);
            elements = newElements;
        }
    }

    public E remove(int index){
        if (index >= 0 && index < elements.length){
            for (int i = index; i < size - 1; i++){
                elements[i] = elements[i+1];
            }
            elements[size - 1] = null;
        }
        size--;
        return (E) elements;
    }

    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if (elements[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e){
        for(int i = 0; i < size; i++){
            if (elements[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e){
        ensureCapacity(1);
        elements[size] = e;
        size++;
        return true;
    }

    public E get(int i){
        return (E) elements[i];
    }

    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
