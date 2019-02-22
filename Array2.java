package Assignments;

//Group Number: 35
//Group Members: Nicholas Fisher. Hannah Maltkvist
public class Array2 {

    private final int max_elements = 200;
    private int size = 0;
    private int[] arr;

    public Array2(int n) {
        if ((n < 0) || (n > max_elements)) {
            throw new IllegalArgumentException("Array size must be non-negative");
        }
        arr = new int[max_elements];
        size = n;
    }

    /**
     *
     * @return the size of the Array
     */
    public int size() {
        return size;
    }

    /**
     * Set the i-th element to x We are not checking whether the index is in bounds,
     * because dereferencing the array element does it for us.
     *
     * @param i the index of the element
     * @param x the element we're adding
     */
    public void set(int i, int x) {
        arr[i] = x;
    }

    /**
     * Get the i-th element, Again, we are not checking if the index is in bounds.
     *
     * @param i the index of the element to get
     * @return the element found
     */
    public int get(int i) {
        return arr[i];
    }

    /**
     *
     * @return the content of the array as a String
     */
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        if (size > 0) {
            res.append(arr[0]);
            for (int i = 1; i < size; ++i) {
                res.append(", ");
                res.append(arr[i]);
            }
        }
        res.append("}");
        return res.toString();
    }

    /**
     * Hands on session 1 Exercise 1 - Insert element x at index i assuming i is max
     * the size of the array.
     *
     * @param i the index where to insert
     * @param x the element to insert
     */
    public void insert(int i, int x) {
        if (i < 0 || i > size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        if (size() == max_elements) {
            throw new IllegalArgumentException("Cannot grow array");
        }

        for (int j = size; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = x;
        size++;

    }

    /**
     * Hands on session 1 Exercise 2
     *
     * @return true if the array is sorted
     */
    public boolean isSorted() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
           return true;
        }


    /**
     * Hands on session 1 Exercise 3
     *
     * @return the length of longest increasing sub array
     */
    public int maxNonDecreasing() {
        if (size == 0){
            return 0;
        }
        int max = 1;
        int currentMax = 1;
        for(int i = 1; i < size; i++){
            if (arr [i-1] <= arr[i]){
               currentMax++;
            }else{
            if (currentMax > max ){
                max = currentMax;
            }
            currentMax=1;
          }
        }
        if (currentMax>max){
            return currentMax;
        }else{
            return max;
        }
    }

    /**
     * Hands on session 1 Exercise 4 - returns the index of the first number in the
     * first matching subarray
     *
     * @param b The subarray to compare with
     * @return the index where the subarray starts
     */
    public int subArrayIndex(Array2 b) {
        for (int i = 0; i<=(size - b.size); i++){
          boolean isEqual = true;
          int j = 0;
          while (isEqual && (j <= b.size)){
              if (arr[i+j]==b.get(j)){
                  j++;
              }else {
                  isEqual = false;
              }
          }
          if (isEqual){
              return i;
          }
        }
        return -1;
    }

    // Internal method for swapping
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Hands on Session 3 Exercise 2 Return the maximum sum of all contiguous
     * subarrays of the array.
     *
     * @param array the array
     * @param lo    the index of the low boundary of the subarray
     * @param hi    the index of the high boundary of the subarray
     * @return the sum of the subarray
     */
    public static int maxSubarraySum(int[] array, int lo, int hi) {
        throw new UnsupportedOperationException();
    }

    /**
     * Assignment 1 Question 1 Reverse the array
     */
    public void reverse() {
        int tempNum = 0;
        for (int i = 0; i<size/2; i++){
            tempNum = arr[i];
            arr[i]=arr[size-1-i];
            arr[size-1-i]=tempNum;
        }
    }

    /**
     * Assignment 1 Question 2 Remove the element of index i from the array.
     *
     * @param i the element to remove
     */
    public void remove(int i) {
        if (i<0||i>size){
            throw new UnsupportedOperationException("Invalid index");
        }
        for(int x = i; x<size; x++){
            arr[x]= arr[x+1];
        }
        size--;
    }

    /**
     * Assignment 1 Question 2 Remove the element of index i from the array. This
     * method may change the order of the other elements of the array.
     *
     * @param i the element to remove
     */
    public void remove2(int i) {
        if (i<0||i>size){
            throw new UnsupportedOperationException("Invalid index");
        }
        arr[i] = arr[size-1];
        size--;
    }

    /**
     * Assignment 1 Question 3 Return the index of the first occurrence of x in the
     * array, or -1 if x does not occur.
     *
     * @param x the element to find
     * @return the index of the first occurrence
     */
    public int find(int x) {
        int num = 0;
        for(int i = 0; i<size; i++){
            if (arr[i]==x){
                num = i;
                break;
            }else{
                num = -1;
            }
        }
        return num;
    }

    /**
     * Assignment 1 Question 4 Find the length of the longest palindrome that is a
     * contiguous subsequence of the array.
     *
     * @return The length of the palindrome
     */

    public int maxPalindrome() {
        int longestPalindrome = 1;
        if (size==0){
            longestPalindrome = 0;
        }
        for (int i = 0; i < this.size; i++) {
            int currentInt = this.arr[i];
            for (int j = this.size - 1; j > i; j--) {
                if (this.arr[j] == currentInt) {
                    int length = isPalindrome2(i, j);
                    if (length > longestPalindrome) {
                        longestPalindrome = length;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    public int isPalindrome2(int i, int j) {
        int length = j - i + 1;
        for (int k = 0; k < (j - i) / 2; k++) {
            if (this.arr[i + k + 1] != this.arr[j - k - 1]) {
                return 1;
            }
        }
        return length;
    }

    /**
     * Assignment 2 Question 3 returns the sum of the largest contiguous ascending
     * array
     *
     * @return the sum
     */

    public int maxInterval() {
        return sumitupbabey(0,size-1);
    }

    public int maxIntervalNonRec() {
        if (size<=1){
            return -1;
        }
        int currentDiff= 0;
        int maxDiff = 0;
        int i = size-1;
        int j = size - 2;
        while (j >= 0) {
            if (arr[i] >= arr[j]&&arr[j]<arr[j+1]) {
                currentDiff = arr[i] - arr[j];
                if (currentDiff > maxDiff) {
                    maxDiff = currentDiff;
                }
                j--;
            } else{
                i = j;
                j--;
            }
        }
        return maxDiff;
    }

    public int sumitupbabey(int left, int right){

        int maxLeftCurrentLength = 0, maxRightCurrentLength = 0, leftCurrentLength = 0, rightCurrentLength = 0, median = (left + right)/2;

        if (size == 0 || size == 1){
            return -1;
        }

        //base case
        if (left == right) {
            return arr[left];
        }

        if (left == right -1 && arr[left] < arr[right]){
            return arr[right] - arr[left];
        }

        if (left == right -1 ){
            return 0;
        }

        int maxLeftLength = sumitupbabey(left, median);
        int maxRightLength = sumitupbabey(median + 1, right);
        if(!(arr[median] > arr[median + 1])) {
            //center to left
            for (int i = median; i > left; i--){
                if (arr[i] < arr[i-1]) {
                    i = left;
                } else {
                    leftCurrentLength = arr[i - 1];
                }
            }
            if(leftCurrentLength == 0) {
                leftCurrentLength = arr[median];
            }
            //to the right to the right
            for (int i = median + 1; i <= right; i++) {
                if (median == right - 1) {
                    rightCurrentLength = arr[i];
                } else {
                    if (arr[i] > arr[i + 1]) {
                        i = right;
                    } else {
                        rightCurrentLength = arr[i + 1];
                    }
                }
            }
            if (rightCurrentLength == 0) {
                rightCurrentLength = arr[median + 1];
            }

        }

        return Math.max(maxLeftLength, Math.max(maxRightLength, (rightCurrentLength - leftCurrentLength)));

    }

    /**
     * Assignment 2 Question 3 Return the median value of an array.
     *
     * @return the median
     */
    public int median (){
        int k = 0;

        return findMedian(0,size-1,(size-1)/2);
    }

    public int findMedian (int startInd, int endInd, int k){
        if (size <= 2){
            return arr[0];
        }

        else if (startInd == endInd) {
            return arr[startInd];
        }
        int pivot = partition(startInd, endInd);
        if (pivot == k) {
            return arr[pivot];
        } else if (k < pivot) {
            return findMedian(startInd, pivot - 1, k);
        } else {
            return findMedian(pivot + 1, endInd, k);
        }
    }
    public int partition(int startIndex, int endIndex) {
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

    public static void main(String[] args) {
        Array2 a = new Array2(3);
        a.set(0,0);
        a.set(1,24);
        a.set(2,27);

        System.out.println(a.sumitupbabey(0, a.size-1));
        System.out.println(a.maxInterval());




    }
}
