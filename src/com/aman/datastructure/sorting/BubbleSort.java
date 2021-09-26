package com.aman.datastructure.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,43,12,23,5,19,17,34,67,1,10,25};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(a->System.out.print(a+" "));
    }

    private static void bubbleSort(int[] arr) {

        for (int i=0; i<arr.length-1; i++){
            Arrays.stream(arr).forEach(a->System.out.print(a+" "));
            System.out.println();
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {

        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
}
