package com.azerfon;

/**
 * Created by oalizada on 12/15/2016.
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by oalizada on 12/12/2016.
 */
public interface MyListInterface<E>  {

    void add(E item);

    void delete(int index);

    E getItem(int index);


    boolean contains(E item);

    String toString(Node<E> list);

    Node<E> getHead();

    void addAtIndex(int index, E value);
}

class MyList<E> implements MyListInterface<E> {

    Node<E> head;
    private int size;


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(E item) {
        if (head == null) {

            head = new Node<E>(null, item);
        } else {

            add(head, item);
        }
        size++;
    }

    private Node<E> add(Node<E> node, E item) {
        if (node.next() == null) {

            node.setNext(new Node<E>(null, item));
        } else {

            add(node.next(), item);
        }
        return node;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            head = head.next();
        } else {
            Node<E> node = head;
            for (int i = 1; i < index; i++) {
                node = node.next();
            }
            node.setNext(node.next().next());
        }
        size--;
    }

    @Override
    public Node<E> getHead() {
        return head;
    }

    @Override
    public void addAtIndex(int index, E value) {
        if (index < 0 && size < index) {
            return;
        } else {
            for (int i = 1; i < index; i++) {
                head.next();
            }

            head.setNext(new Node<E>(head.next(), value));

        }
    }



    @Override
    public E getItem(int index) {
        return null;
    }


    @Override
    public boolean contains(E item) {

        return containsRec(head, item);

    }

    public boolean containsRec(Node<E> node, E item) {
        if (node == null) {
            return false;
        }
        if (item.equals(node.getElement())) {
            return true;
        } else {

            return containsRec(node.next(), item);
        }

    }




    //2,3,4
    public String toString(Node<E> node) {
        if (node == null) {
            return "";
        }
        Node nextNode = node.next();
        if (nextNode == null) {
            return node.getElement() + ":";
        } else {


            return node.getElement() + ":" + toString(nextNode);
        }
    }

}

class Node<E> {
    private Node<E> next;
    private E element;

    public Node(Node<E> next, E element) {
        this.next = next;
        this.element = element;
    }

    public Node<E> next() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}


class MainTest {
    public static void main(String[] args) {
        MyListInterface<String> a = new MyList<String>();
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");
        a.add("33");
        a.add("41");
        a.add("21");
        a.add("34");
        System.out.println(a.toString(a.getHead()));
        a.delete(7);

        System.out.println(a.toString(a.getHead()));
        System.out.println(a.contains("57"));
        a.addAtIndex(2, "56");
        System.out.println(a.toString(a.getHead()));
    }
}