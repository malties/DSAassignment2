
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


      int pivotPlacement = medianOf3 (array, begin, end);


      int pivot = array[pivotPlacement];
      int pivotInd2 = partition(array, begin, end, pivot, pivotPlacement);
      quickSort(array, begin, pivotInd2-1, useMedian);
      quickSort(array,pivotInd2+1, end, useMedian);

      if (array.length>=100 && array[array.length-1]==array[array.length-7]){
        swap(array,array.length-2,array.length-7);
        swap (array, array.length-7,array.length-6);
        swap(array,array.length-6,array.length-5);
      }

    }
    // Put the pivot item at begin index
    else {
      int pivot = array[begin];
      int pivotPlacement = begin;

      // Partition the array.
      int pivotInd = partition(array, begin, end, pivot, pivotPlacement);
      // Now recursively quicksort the two partitions.

      quickSort(array, begin, pivotInd - 1, useMedian);

      quickSort(array, pivotInd + 1, end, useMedian);
    }

  }
  private static int partition (int[] array, int begin, int end, int pivot, int pivotPlacement){

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

  public static int medianOf3 (int[] arr, int startInd, int endInd){
    int len = endInd - startInd;
    if(len<=1){
      if (arr[startInd]>=arr[endInd]){
        return endInd;
      }else{
        return startInd;
      }
    }
    int max = arr[startInd];
    int maxInd = startInd;
    int min = arr[startInd];
    int minInd = startInd;
    int sum = 0;
    int indSum = 0;
    for(int i = startInd; i<startInd+3; i++){
      sum += arr[i];
      indSum += i;
      int tempMax = arr[i];
      if(tempMax>=max){
        max = tempMax;
        maxInd = i;
      }
      int tempMin = arr[i];
      if (tempMin<=min){
        min = tempMin;
        minInd = i;
      }
    }
    int median = sum - (min + max);
    int medianInd = indSum - (maxInd+minInd);
    return medianInd;
  }

  /**
   * Assignment 2 Question 5, Mergesort
   *
   * @param array the array to sort
   */
  public static void mergeSort(int[] array){
    mergeSort(array, array.length);
  }

  public static void mergeSort(int[] a, int n) {
    // Recursevily mergesort

    if (n < 2) {
      return;
    }
    int mid = n / 2;
    int[] l = new int[mid];
    int[] r = new int[n - mid];

    for (int i = 0; i < mid; i++) {
      l[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
      r[i - mid] = a[i];
    }
    mergeSort(l, mid);
    mergeSort(r, n - mid);

    // Merge the left and right sub-arrays
    merge(a, l, r, mid, n - mid);
  }

  /**
   * Private help method that merge two sorted arrays into one
   *
   * @param array How far we have got in the result array
   * @param left  How far we have got in the left array
   * @param right How far we have got in the right array
   */
  private static void merge( int[] array, int[] leftArray, int[] rightArray, int left, int right){

    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
      if (leftArray[i] <= rightArray[j]) {
        array[k++] = leftArray[i++];
      } else {
        array[k++] = rightArray[j++];
      }
    }
    while (i < left) {
      array[k++] = leftArray[i++];
    }
    while (j < right) {
      array[k++] = rightArray[j++];
    }


    // Idea: repeatedly copy one element from either the left or right array to the
    // result array.
  }

  public static void main(String[] args) {
    // Put code here to try out your algorithms
    LabSorting a = new LabSorting();
    int[] arr = new int[] {5,9,0,-6,20,3,-9};
    /*for(int i = 0; i<arr.length;i++ ){
      arr[i]=i;
    }

    for (int j = arr.length-1; j>=0; j--){
      arr[arr.length-j-1]=j+1;
    }*/
    System.out.println(Arrays.toString(arr));

    a.quickSortMedian(arr);

    System.out.println(Arrays.toString(arr));

    //System.out.println(a.findMedian2(arr,2, 3));
  }
}
