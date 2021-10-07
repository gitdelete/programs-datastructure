package com.aman.datastructure.heap;


import java.util.Arrays;

// Program to create a binary maxheap tree from an array
public class MaxHeapify {

    public static void main(String[] args) {
        int[] arr = {3,43,12,23,5,19,17,34,67,1,10,25};

        // Starting from one level up the leaf nodes
        int startIdx = (arr.length / 2) - 1;
        for(int i=startIdx; i>=0; i--)
            maxHeapify(arr,i);

        Arrays.stream(arr).forEach(a->System.out.print(a+" "));
    }

    private static void maxHeapify(int[] arr, int i) {

        int largest = i;
        int left=(2*i)+1;
        int right=(2*i)+2;
        if(left<arr.length && arr[i]<arr[left]){
            largest=left;
        }
        if(right < arr.length && arr[largest]<arr[right]){
            largest=right;
        }

        if(largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr,largest);
        }
    }

    private static void swap(int[] arr, int i, int largest) {

        int temp= arr[i];
        arr[i]=arr[largest];
        arr[largest]=temp;
    }

}
