package Assignments;

import java.util.Arrays;

public class LabSorting  {

  /**
   * Private help-method that swaps two elements in an array
   *
   * @param array the array in question
   * @param i     one of the elements to swap
   * @param j     the other element to swap
   */
  private static void swap(int[] array, int i, int j) {
    int x = array[i];
    array[i] = array[j];
    array[j] = x;
  }

  /**
   * Hands on session 2 Exercise 1 Bubble sort
   *
   * @param array the array to sort
   */
  public static void bubbleSort(int[] array) {


    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length-i-1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }

  public static void bubbleSort2 (int[] array){
    boolean swapped = true;
    for (int i = 0; swapped & i < array.length-1; i++){
      swapped = false;
      for (int j = 0; j<array.length-i-1; j++){
        if (array[j+1]<array[j]){
          swap(array,j+1, j);
          swapped = true;
        }
      }
    }
  }

  /**
   * Hands on session 2 Exercise 2 Insertion sort
   *
   * @param array The array to sort
   */
  public static void insertionSort(int[] array) {
    for (int i = 1; i<array.length; i++){
      int temp = array[i];
      int j = i;
      for(; j>0 && temp<array[j-1];j--){
        array [j] = array[j-1];
      }
      array [j] = temp;
    }
  }

  /**
   * Hands on session 4 & Assignment 2 Question 5 Quicksort
   *
   * @param array the array to sort
   */
  public static void quickSort(int[] array) {
    quickSort(array, 0, array.length - 1, false);
  }

  public static void quickSortMedian(int[] array) {
    quickSort(array, 0, array.length - 1, true);
  }

  // Quicksort part of an array


  private static void quickSort(int[] array, int begin, int end, final boolean useMedian) {
    // Base case.
    if (begin >= end) {
      return;
    }
    // Use median as pivot
    if (useMedian) {
      int pivot2 = findMedian (array, begin, end, end/2);
      int pivotPlacement = (begin+end)/2;
      int pivotInd2 = partition3(array, begin, end, pivot2, pivotPlacement);
      quickSort(array, begin, pivotInd2-1, useMedian);
      quickSort(array,pivotInd2+1, end, useMedian);

    }
    // Put the pivot item at begin index
      else {
      int pivot = array[begin];
      int pivotPlacement = begin;

      // Partition the array.
      int pivotInd = partition3(array, begin, end, pivot, pivotPlacement);
      // Now recursively quicksort the two partitions.

      quickSort(array, begin, pivotInd - 1, useMedian);

      quickSort(array, pivotInd + 1, end, useMedian);
    }

  }

  private static int partition (int[] array, int begin, int end, int pivot){
    //int pivot = array[begin];
    //int middle = (begin+end)/2;

    swap(array,begin,end);
    int i = begin -1;
    for (int j = begin; j<end; j++){
      if (array[j]< pivot){
        i++;
        swap(array,i, j);
      }
    }
    // Move the pivot to the right place
    swap(array, i+1,end);
    int pivotInd = i+1;

    return pivotInd;
  }

  private static int partition2(int[] array, int begin, int end, int pivot){
    //int pivot = array[begin];
    //int middle = (begin+end)/2;
    swap(array,begin,end);
    int i = -1;
    for (int j = 0; j<end; j++){
      if (array[j]< pivot){
        i++;
        swap(array,i, j);
      }
    }
    // Move the pivot to the right place
    swap(array, i+1,end);
    int pivotInd = i+1;

    return pivotInd;
  }

  private static int partition3 (int[] array, int begin, int end, int pivot, int pivotPlacement){

    swap(array,pivotPlacement,end);

    int i = begin;
    int j = end-1;
    while (i<=j){
      if(array[i]<=pivot && array[j]>=pivot) {
        i++;
        j--;
      }else if(array[i]>pivot && array[j]>=pivot){
        j--;
      }else if (array[i]<=pivot && array[j]<pivot){
        i++;
      }else if(array[i]>pivot && array[j]<pivot){
        swap(array, i, j);
      }
    }
    // Move the pivot to the right place
    swap(array, i,end);
    int pivotInd = i;

    return pivotInd;
  }

  private static int findMedian (int[]arr, int start, int end, int k){
    if (arr.length <= 2){
      return arr[0];
    }

    else if (start == end) {
      return arr[start];
    }
    int pivot = medianPartition(arr, start, end);
    if (pivot == k) {
      return arr[pivot];
    } else if (k < pivot) {
      return findMedian( arr, start, pivot - 1, k);
    } else {
      return findMedian(arr,pivot + 1, end, k);
    }
  }

  private static int medianPartition(int[] arr, int startIndex, int endIndex) {
    int pivot = startIndex;
    int partitionIndex = startIndex;
    for (int i = startIndex; i <= endIndex; i++) {
      if (arr[i] <= arr[pivot]) {
        swap(arr, i,partitionIndex);

        partitionIndex++;
      }
    }

    swap(arr, partitionIndex-1, pivot);

    return partitionIndex-1;
  }

  /**
   * Assignment 2 Question 5, Mergesort
   *
   * @param array the array to sort
   */
  public static void mergeSort(int[] array) {
    // Recursevily mergesort


    // Merge the left and right sub-arrays
    throw new UnsupportedOperationException();
  }

  /**
   * Private help method that merge two sorted arrays into one
   *
   * @param array How far we have got in the result array
   * @param left  How far we have got in the left array
   * @param right How far we have got in the right array
   */
  private static void merge(int[] array, int[] left, int[] right) {

    // Idea: repeatedly copy one element from either the left or right array to the
    // result array.
    throw new UnsupportedOperationException();
  }

  public static void main(String[] args) {
    // Put code here to try out your algorithms
    LabSorting a = new LabSorting();
    int[] arr = new int[] {7,4,3,8,5,40,8,9,1,5,7,0,2,4,6,7};
    System.out.println(Arrays.toString(arr));
    a.quickSort(arr, 0, arr.length-1, false);
    System.out.println(Arrays.toString(arr));
    //System.out.println(a.findMedian(arr, 0, 9, (arr.length-1)/2));
  }
}
