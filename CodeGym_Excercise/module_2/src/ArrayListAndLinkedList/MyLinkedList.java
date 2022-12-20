package ArrayListAndLinkedList;

import javax.xml.soap.Node;

public class MyLinkedList {
    private  Node head;
    private  int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    private class Node {
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

public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
}
}

class TestMyLinkedList{
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(10);
    myLinkedList.addFirst(2);
    myLinkedList.addFirst(3);
    myLinkedList.addFirst(5);
    myLinkedList.addFirst(6);
    myLinkedList.addFirst(2);
    myLinkedList.add(2,2);
    myLinkedList.printList();
    }
}