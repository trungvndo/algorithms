package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void sort(int[] nums) {
        mergeSort(nums);
    }

    private static void mergeSort(int[] nums) {
        int n = nums.length;
        if (n < 2) return;

        int middle = n / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[n - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = nums[i];
        }

        for (int i = 0; i < n-middle; i++) {
            rightArray[i] = nums[i+middle];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            if ((left < middle) && (right >= n - middle || leftArray[left] <= rightArray[right])) {
                nums[i] = leftArray[left++];
            } else {
                nums[i] = rightArray[right++];
            }
        }
    }


}
