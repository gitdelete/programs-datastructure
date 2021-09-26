package com.aman.datastructure.search;

import java.util.Arrays;

public class Binary_Search {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        binarySearch(arr,1);
        binarySearch(arr,2);
        binarySearch(arr,3);
        binarySearch(arr,4);
        binarySearch(arr,5);
        binarySearch(arr,6);
        binarySearch(arr,7);
        binarySearch(arr,8);
        binarySearch(arr,9);
        binarySearch(arr,10);
        binarySearch(arr,11);
        binarySearch(arr,12);
        binarySearch(arr,13);
    }

    private static void binarySearch(int[] arr, int search) {

        int low=0;
        int high=arr.length-1;
        int mid=((high-low)/2);
        while(low<=high){
            if (search == arr[mid]) {
                System.out.println("Found " + arr[mid] +" at index "+ mid);
                break;
            }
            if(search < arr[mid]){
                high=mid-1;

            }else if(search > arr[mid]) {
                low=mid+1;
            }
            mid = ((high+low)/2);
        }

    }
}
