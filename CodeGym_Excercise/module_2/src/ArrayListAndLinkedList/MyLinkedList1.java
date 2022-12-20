package ArrayListAndLinkedList;

import javax.xml.soap.Node;

public class MyLinkedList1<E> {
    private Node head;
    private int numNodes;

    private E element[];

    public MyLinkedList1(Object data) {
        head = new Node(data);
    }

    private class Node{
    private Node next;
    private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, Object data){
        Node temp = head;
        Node holder;
        for( int i = 0; i < index - 1 && temp.next != null; i++){
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data){
        Node temp =head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public Node get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public int size(){
        return numNodes;
    }

    public void addLast(Object data){
        Node temp = head;
    for (int i = 0; i < numNodes - 1; i++){
        temp = temp.next;
    }
        temp.next = new Node(data);
        temp = temp.next;
        numNodes++;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void remove(int index){
        Node temp = head;
        for(int i = 0; i < index -1; i++){
            temp = temp.next;
        }
        Node current = temp.next;
        temp = current.next;
        numNodes--;
    }
}

class TestMyLinkedList1{
    public static void main(String[] args) {
        MyLinkedList1 myLinkedList1 = new MyLinkedList1(10);
        myLinkedList1.addFirst(5);
        myLinkedList1.addFirst(4);
        myLinkedList1.addFirst(3);
        myLinkedList1.addFirst(2);
        myLinkedList1.addFirst(1);
        myLinkedList1.addLast(5);
        myLinkedList1.remove(2);
        myLinkedList1.printList();
    }
}