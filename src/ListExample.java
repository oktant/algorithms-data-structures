package com.azerfon;

/**
 * Created by oalizada on 12/21/2016.
 */
class ListNode<T> {
    T data;
    ListNode<T> nextNode;

    ListNode(T object) {
        this(object, null);
    }

    ListNode(T object, ListNode<T> node) {
        data = object;
        nextNode = node;
    }

    T getData() {
        return data;
    }

    ListNode<T> getNext() {
        return nextNode;
    }

}


public class ListExample<T> {
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private String name;

    public ListExample() {
        this("list");
    }

    public ListExample(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    public void insertAtFront(T insertItem) {
        if (isEmpty())
            firstNode = lastNode = new ListNode<T>(insertItem);
        else
            firstNode = new ListNode<T>(insertItem, firstNode);
    }

    public void insertAtBack(T insertItem) {
        if (isEmpty())
            firstNode = lastNode = new ListNode<T>(insertItem);
        else
            lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s \n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode<T> current = firstNode;

        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }
        System.out.println("\n");
    }

    public T removeFromFront() throws EmptyListException {

        if (isEmpty())
            throw new EmptyListException();

        T removedItem = firstNode.data;
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.nextNode;

        return removedItem;

    }

    public T removeFromBack() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException();

        T removedItem = lastNode.data;

        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else {
            ListNode<T> current = firstNode;
            while (current.nextNode != lastNode)
                current = current.nextNode;

            lastNode = current;
            current.nextNode = null;

        }

        return removedItem;

    }


}
class EmptyListException extends RuntimeException{
    public EmptyListException() {
        this("list");
    }
    public EmptyListException(String list) {
        super(list + " is empty");
    }
}
