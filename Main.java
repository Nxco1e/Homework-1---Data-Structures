//Name: Nicole Shmerkin
//Programming Language: Java
//IDE/Editor: VS Code

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int [] arr = {1, 11, 21, 12, 22, 2, 3, 33, 31, 13, 23, 32};
        System.out.println("Original Array:");
        printArray(arr);

        int[] bubbleSortedArr = arr.clone();
        bubbleSort(bubbleSortedArr);

        System.out.println();
        System.out.println("Bubble Sort Result:");
        printArray(bubbleSortedArr);

        int[] mergeSortedArr = arr.clone();
        mergeSort(mergeSortedArr, 0, mergeSortedArr.length - 1);

        System.out.println();
        System.out.println("Merge Sort Result:");
        printArray(mergeSortedArr);

        System.out.println();
        System.out.println("Linear Search");
        int originalTarget = 23;
        int originalFoundIndex = linearSearch(arr, originalTarget);
        System.out.println();
        System.out.println("Searching for: " + originalTarget);
        if (originalFoundIndex != -1) {
            System.out.println("Target found at index " + originalFoundIndex);
        } else {
            System.out.println("Target not found.");
        }

        int[] targets = {11, 32, 50};
        System.out.println();
        System.out.println("Additional Linear Search Tests:");
        for (int target : targets) {
            int foundIndex = linearSearch(arr, target);
            System.out.println();
            System.out.println("Searching for: " + target);
            if (foundIndex != -1) {
                System.out.println("Target found at index " + foundIndex);
            } else {
                System.out.println("Target not found.");
            }
        }

        System.out.println();
        System.out.println("Binary Search:");
        int binaryTarget = 23;
        int binaryFoundIndex = binarySearch(mergeSortedArr, binaryTarget);
        System.out.println();
        System.out.println("Searching for: " + binaryTarget);
        if (binaryFoundIndex != -1) {
            System.out.println("Target found at index " + binaryFoundIndex);
        } else {
            System.out.println("Target not found.");
        }

        int[] binaryTargets = {11, 32, 50};
        System.out.println();
        System.out.println("Additional Binary Search Tests:");
        for (int target : binaryTargets) {
            int foundIndex = binarySearch(mergeSortedArr, target);
            System.out.println();
            System.out.println("Searching for: " + target);
            if (foundIndex != -1) {
                System.out.println("Target found at index " + foundIndex);
            } else {
                System.out.println("Target not found.");
            }
        }
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // The worst-case Big O time complexity of bubble sort is O(n^2).
    // The Bubble Sort has this time complexity because in the worst case, it needs to compare and potentially swap each element with every other element in the array, resulting in a quadratic number of operations. The repeated comparisons and swaps lead to O(n^2) time complexity.
    // If Bubble Sort processes 10 elements, the number of comparisons in the worst case would be approximately 10^2 = 100. For 1000 elements, the number of comparisons in the worst case would be approximately 1000^2 = 1,000,000. This demonstrates the quadratic growth of the number of comparisons as the input size increases, which is characteristic of O(n^2) time complexity.

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    // The Big O time complexity of linear search is O(n). This is because in the worst case, it may need to check each element in the array once.
    // The Big O time complexity of binary search is O(log n). This is because it repeatedly divides the search interval in half, reducing the number of elements to check exponentially.
    // Binary Search requires sorted data because it relies on the order of elements to eliminate half of the search space at each step. It will not work correctly on unsorted data.
    // I would use linear search for unsorted data because binary search requires sorted data to function correctly. It also has a simpler implementation and does not require any preprocessing of the data.
    // For a very large sorted array, I would use binary search because it has a more efficient time complexity of O(log n) compared to linear search's O(n). It also reduces the number of comparisons needed to find the target element.
}