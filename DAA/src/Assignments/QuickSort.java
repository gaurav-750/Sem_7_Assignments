package Assignments;


import java.util.Arrays;
import java.util.Random;

//Write a program for analysis of quick sort by using deterministic and randomized variant
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {10,80,30,90,40};

        //deterministic variation
//        quickSort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));

        randomizedQuickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void randomizedQuickSort(int[] arr, int l, int r) {
        //base case
        if (l >= r)
            return;

        System.out.println(l + "," + r);

        int pivotIndex = randomPartition(arr, l, r);

        randomizedQuickSort(arr, l, pivotIndex-1);
        randomizedQuickSort(arr, pivotIndex+1, r);
    }

    private static int randomPartition(int[] arr, int low, int high) {

        randomPivot(arr, low, high);
        //now we have the randomPivotElement at index 'high'
        int pivot = arr[high];

        int ptr = (low-1);

        for (int i = low; i < high; i++){
            //if current element is smaller than pivot
            if (arr[i] < pivot){
                ptr++;
                swap(arr, ptr, i);
            }
        }


        ptr += 1;
        //swap pivot element(last element) with ptr
        swap(arr, ptr, high);
        return ptr;
    }

    private static void randomPivot(int[] arr, int low, int high) {
        Random random = new Random();
        int randomPivotIndex = random.nextInt(high - low) + low;
        System.out.println("randomPivotIndex = " + randomPivotIndex);

        //place the element at randomPivotIndex -> high
        int temp = arr[high];
        arr[high] = arr[randomPivotIndex];
        arr[randomPivotIndex] = temp;
    }

    private static void quickSort(int[] arr, int l, int r) {
        //base case
        if (l >= r)
            return;


        int partitionIndex = partition(arr, l, r);
//        System.out.println("partitionIndex = " + partitionIndex);

        //sort both the left and right part of pivotIndex recursively
        quickSort(arr, l, partitionIndex-1);
        quickSort(arr, partitionIndex+1, r);
    }

    private static int partition(int[] arr, int low, int high) {
        //choosing the pivot
        //TODO we'll take the 'rightmost' element as our pivot
        int pivot = arr[high];

        int ptr = (low-1);

        for (int i = low; i < high; i++){
            //if current element is smaller than pivot
            if (arr[i] < pivot){
                ptr++;
                swap(arr, ptr, i);
            }
        }


        ptr += 1;
        //swap pivot element(last element) with ptr
        swap(arr, ptr, high);
        return ptr;
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}