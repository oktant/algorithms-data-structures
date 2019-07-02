package com.azerfon;


/**
 * Created by oalizada on 12/19/2016.
 */
class LinkedListHash {
    private int key;
    private int value;
    private LinkedListHash next;

    LinkedListHash(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedListHash getNext() {
        return next;
    }

    public void setNext(LinkedListHash next) {
        this.next = next;
    }


}

public class HashTable {
    LinkedListHash[] theArray;
    int size;

    public HashTable(int size) {
        this.size = getNextPrime(size);
        theArray = new LinkedListHash[size];

    }


    public void put(int key, int value) {
        int hash = (key % size);
        if (theArray[hash] == null) {
            theArray[hash] = new LinkedListHash(key, value);
        } else {
            LinkedListHash entry = theArray[hash];
            while (entry.getNext() != null && entry.getKey() != key) entry = entry.getNext();
            if (entry.getKey() == key) {
                entry.setValue(value);
            } else {
                entry.setNext(new LinkedListHash(key, value));
            }
        }
    }

    public int get(int key) {
        int hash = (key % size);
        if (theArray[hash] == null) {
            return -1;
        } else {
            LinkedListHash entry = theArray[hash];
            while (entry != null && entry.getKey() != key) entry = entry.getNext();
            if (entry == null) {
                return -1;
            } else
                return entry.getValue();
        }
    }

    public void remove(int key) {
        int hash = (key % size);
        if (theArray[hash] != null) {
            LinkedListHash prevEntry = null;
            LinkedListHash entry = theArray[hash];
            while (entry.getNext() != null && entry.getKey() != key) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getKey() == key) {
                if (prevEntry == null) {
                    theArray[hash] = entry.getNext();
                } else
                    prevEntry.setNext(entry.getNext());
            }
        }
    }

    public int getNextPrime(int minSize) {
        if (isPrime(minSize)) {
            return minSize;

        } else {
            boolean is = true;
            while (is) {
                minSize++;
                if (isPrime(minSize)) {
                    return minSize;
                }

            }
            return minSize;
        }

    }


    public boolean isPrime(int number) {
        if (number % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


}
