package com.azerfon;

/**
 * Created by oalizada on 12/21/2016.
 */
public class SortingAlgo {
    public static void bubbleSrt(int[] array) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (array[j] < array[j - 1]) {

                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }


        }
        printNumbers(array);
    }


    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i; j > 0; j--) {
                if (array[j - 1] < tmp) {
                    break;
                }
                array[j] = array[j - 1];
            }
            array[j] = tmp;

        }
        printNumbers(array);

    }


    public static void printNumbers(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        System.out.println("==================Bubble Sort==========================");
        bubbleSrt(input);
        System.out.println("-------------------------------------------------------");
        System.out.println();

        int[] input1 = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        System.out.println("==================Selection Sort==========================");
        selectionSort(input1);
        System.out.println("-------------------------------------------------------");
        System.out.println();
        int[] input2 = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        System.out.println("==================Insertion Sort==========================");
        selectionSort(input2);
        System.out.println("-------------------------------------------------------");
        System.out.println();
        int[] input3 = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        System.out.println("==================Merge Sort==========================");
        int[] result = mergeSort(input3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.println();

        System.out.println("-------------------------------------------------------");
        System.out.println();


        int[] input4 = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        sort(input4);
        for (int i : input) {
            System.out.print(i);
            System.out.print(" ");
        }
    }


    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {  //0
            int min = i;
            for (int j = i + 1; j < array.length; j++) {   //1
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        printNumbers(array);
    }

    public static void sort(int[] array){
        if(array==null || array.length==0){
            return;
        }
        int length=array.length;
        quickSort(0,length-1, array);

    }

    private static  void quickSort(int lowerIndex,int higherIndex, int[]array ){
            int i=lowerIndex;
        int j=higherIndex;
        int pivot=array[(lowerIndex+higherIndex)/2];
        while(i<=j){
            while(array[i]<pivot){
                i++;
            }
            while(array[j]>pivot){
                j--;
            }
            if(i<=j){
                exchangeNumbers(i, j, array);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j, array);
        if (i < higherIndex)
            quickSort(i, higherIndex, array);
    }
    private static void exchangeNumbers(int i, int j,int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int midpoint = array.length / 2;
        int[] left = new int[midpoint];
        int[] right;
        if (array.length % 2 == 0) {
            right = new int[midpoint];
        } else {
            right = new int[midpoint+1];
        }
        int[] result = new int[array.length];
        for (int i = 0; i < midpoint; i++) {
            left[i] = array[i];
        }
        int x = 0;
        for (int i = midpoint; i < array.length; i++) {
            if (x < right.length) {
                right[x] = array[i];
                x++;
            }
        }
        left = mergeSort(left);
        right =mergeSort(right);
        result=merge(left, right);
        return result;
    }
        private static int[] merge (int[]left, int[]right){
            int lengthResult=left.length+right.length;
            int[] result=new int[lengthResult];
            int indexL= 0;
            int indexR=0;
            int indexRes=0;
            while(indexL<left.length || indexR<right.length ){
                if(indexL<left.length && indexR<right.length){
                   if(left[indexL]<=right[indexR]){
                       result[indexRes]=left[indexL];
                        indexL++;
                       indexRes++;
                   }
                    else{
                       result[indexRes]=right[indexR];
                        indexR++;
                       indexRes++;
                   }
                }
                else if(indexL<left.length){
                    result[indexRes]=left[indexL];
                    indexL++;
                    indexRes++;
                }
                else{
                    result[indexRes]=right[indexR];
                    indexR++;
                    indexRes++;

                }
            }
            return result;
        }

    }


