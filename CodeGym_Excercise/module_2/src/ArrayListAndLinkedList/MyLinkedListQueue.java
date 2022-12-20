package ArrayListAndLinkedList;

import javax.xml.soap.Node;

public class MyLinkedListQueue {
    private Node1 head;
    private Node1 tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int key){
        Node1 temp = new Node1(key);
        if (this.tail == null){
            this.head = this.tail = temp;
            return;
        }
            this.tail.next = temp;
            this.tail = temp;
    }

    public Node1 dequeue(){
        if (this.head == null){
            return null;
        }
        Node1 temp = this.head;
        this.head = this.head.next;
        if(this.head == null){
            this.tail = null;
        }
        return temp;
    }
}
class Node1 {
    public int key;
    public Node1 next;

    public Node1(int key) {
        this.key = key;
        this.next = null;
    }
}

class LinkedListQueueClient{
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Dequeued item is " + queue.dequeue().key);
    }
}