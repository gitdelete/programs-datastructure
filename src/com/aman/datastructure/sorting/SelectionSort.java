package com.aman.datastructure.sorting;


import java.util.Arrays;

//Move largest element to last in single pass
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3,43,12,23,5,19,17,34,67,1,10,25};
        selectionSort(arr);
        Arrays.stream(arr).forEach(a->System.out.print(a+" "));
    }

    private static void selectionSort(int[] arr) {

        for (int i=0; i<arr.length-1; i++){
            for (int j=i+1;j<arr.length;j++){
                    if(arr[i]>arr[j]){
                        swap(arr,i,j);
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
