package com.azerfon;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by oalizada on 12/19/2016.
 */
public class MaxHeap<T extends Comparable> {
    private ArrayList<T> items;

    MaxHeap() {
        items = new ArrayList<>();
    }

    public void siftUp() {
        int k = items.size() - 1;
        while (k > 0) {
            int p = (k - 1) / 2;

            T parent = items.get(p);
            T child = items.get(k);

            if (parent.compareTo(child) < 0) {
                items.set(k, parent);
                items.set(p, child);
                k = p;
            } else break;
        }
    }

    public void siftDown() {
        int k = 0;
        int left = 2 * k + 1;
        while (left < items.size()) {
            if (left < items.size()) {
                int max = left;
                int right = left + 1;
                if (right < items.size()) {
                    if (items.get(right).compareTo(items.get(left)) > 0) {
                        max++;
                    }
                }
                if (items.get(k).compareTo(items.get(max)) < 0) {
                    T temp = items.get(k);
                    items.set(k, items.get(max));
                    items.set(max, temp);
                    k=max;
                    left=2*k+1;
                }
                else break;
            }

        }
    }
    public void add(T insert){
        items.add(insert);
        siftUp();
    }
    public T delete(){
        if(items.size()==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        else if(items.size()==1){
           return items.remove(0);
        }
        else{
            T hold=items.get(0);
            items.set(0, items.remove(items.size()-1));
            siftDown();
            return hold;
        }
    }
    public boolean isEmpty(){
        return isEmpty();
    }
    public int size(){
        return items.size();
    }
    public String toString(){
            return items.toString();
    }
}
