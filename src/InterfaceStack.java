package com.azerfon;

/**
 * Created by oalizada on 12/15/2016.
 */
public interface InterfaceStack<E> {
    E getElementFirst();
    E pop();
    void push(E element);


}

class Stack<T> {
    private ListExample<T> stackList;

    public Stack() {
        stackList= new ListExample<T>("stack");
    }

    public void push(T object){
        stackList.insertAtFront(object);
    }

    public T pop(){
        return stackList.removeFromFront();
    }

    public boolean isEmpty(){
        return stackList.isEmpty();
    }

    public void print(){
        stackList.print();
    }


}

class MainStackTest{

}

