package deque;

import java.util.Arrays;
import java.util.Scanner;

public class mergsort {
    private static Scanner sc;

    public static void main(String args[]) {
        int[] arr = new int[]{61,1,65,35,20};


        mergesort(arr);
    }

    static void mergesort(int arr[]) {
        int n = arr.length;
        if (n < 2)
            return;
        int mid = n / 2;
        int left[] = new int[mid];
        int right[] = new int[n - mid];
        for (int i = 0; i < mid; i++)
            left[i] = arr[i];
        for (int i = mid; i < n; i++)
            right[i - mid] = arr[i];
        mergesort(left);
        mergesort(right);
        merge(arr, left, right);
    }

    public static void merge(int arr[], int left[], int right[]) {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0, k = 0;
        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nL) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < nR) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}