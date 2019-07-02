package com.azerfon;

/**
 * Created by oalizada on 12/15/2016.
 */

public interface InterfaceQueue<T> {

    public void enqueue(T object);
    public T dequeue();
    public boolean isEmpty();


}


/**
 * Created by eabukerov on 12/8/2016.
 */
class Queue<T> implements InterfaceQueue<T> {
    private ListExample<T> queueList;

    public Queue() {
        queueList = new ListExample<>("queue");
    }

    public void enqueue(T object){
        queueList.insertAtBack(object);
    }

    public T dequeue() throws EmptyListException{
        return queueList.removeFromFront();
    }

    public boolean isEmpty(){
        return queueList.isEmpty();
    }

    public void print(){
        queueList.print();
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("test");
        queue.enqueue("asdasd");
        queue.enqueue("adasd");
        queue.enqueue("asdqweqwe");
        queue.print();
        System.out.println(queue.dequeue());
        System.out.println("_____________");
        queue.print();
    }
}



