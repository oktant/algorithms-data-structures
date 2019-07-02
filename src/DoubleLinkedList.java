package com.azerfon;

/**
 * Created by oalizada on 12/15/2016.
 */
class ListImplNode<T>{
    T data;
    ListImplNode<T> nextNode;

    public ListImplNode(T object) {
        this(object, null);
    }

    public ListImplNode(T object, ListImplNode<T> node) {
        data = object;
        nextNode = node;
    }

    public T getData() {
        return data;
    }

    public ListImplNode<T> getNextNode() {
        return nextNode;
    }
}
public class DoubleLinkedList<E> {

    public class ListImpl<T> {
        private ListImplNode<T> firstNode;
        private ListImplNode<T> lastNode;
        private String name;

        public ListImpl() {
            this("list");
        }

        public ListImpl(String list) {
            name = list;
            firstNode = lastNode = null;
        }

        public void insertAtFront(T insertItem) {
            if (isEmpty())
                firstNode = lastNode = new ListImplNode<T>(insertItem);
            else
                firstNode = new ListImplNode<T>(insertItem, firstNode);
        }

        public void insertAtBack(T insertItem) {
            if (isEmpty())
                firstNode = lastNode = new ListImplNode<T>(insertItem);
            else
                lastNode = lastNode.nextNode = new ListImplNode<T>(insertItem);
        }

        public T removeFromFront() throws Exception {
            if (isEmpty())
                throw new Exception();

            T removedItem = firstNode.data;

            if (firstNode == lastNode)
                firstNode = lastNode = null;
            else
                firstNode = firstNode.nextNode;

            return removedItem;
        }

        public T removeFromBack() throws Exception {
            if (isEmpty())
                throw new Exception();

            T removedItem = lastNode.data;

            if (firstNode == lastNode)
                firstNode = lastNode = null;
            else {
                ListImplNode<T> current = firstNode;

                while (current.nextNode != lastNode)
                    current = current.nextNode;

                lastNode = current;
                current.nextNode = null;
            }

            return removedItem;


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
            ListImplNode<T> current = firstNode;

            while (current != null) {
                System.out.println(current.data);
                current = current.nextNode;
            }

            System.out.println();

        }

    }
}