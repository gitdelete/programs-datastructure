package com.aman.datastructure.heap;

import java.util.Arrays;

public class MinHeapify {

    public static void main(String[] args) {
        int[] arr = {3,43,12,23,5,19,17,34,67,1,10,25};
        int startIdx = (arr.length / 2) - 1;
        for(int i=startIdx; i>=0; i--)
            minHeapify(arr,i);

        Arrays.stream(arr).forEach(a->System.out.print(a+" "));
    }

    private static void minHeapify(int[] arr, int i) {

        int smallest = i;
        int left=(2*i)+1;
        int right=(2*i)+2;
        if(left<arr.length && arr[i]>arr[left]){
            smallest=left;
        }
        if(right < arr.length && arr[smallest]>arr[right]){
            smallest=right;
        }

        if(smallest != i) {
            swap(arr, i, smallest);
            minHeapify(arr,smallest);
        }
    }

    private static void swap(int[] arr, int i, int smallest) {

        int temp= arr[i];
        arr[i]=arr[smallest];
        arr[smallest]=temp;
    }
}
