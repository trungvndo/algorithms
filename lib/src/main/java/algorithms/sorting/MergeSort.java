package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static int[] sort(int[] nums) {
        return sort(nums, 0, nums.length -1);
    }

    private static int[] sort(int[] nums, int left, int right) {
        if (left == right) return nums;
        int middle = left + (right - left) / 2;
        int[] leftArray = sort(nums, left, middle);
        int[] rightArray = sort(nums, middle + 1, right);


        int[] result = new int[nums.length];

        int p = left;
        int q = middle + 1;

        for (int i = left; i <= right; i++) {
            if ((p <= middle) && (q > right || leftArray[p] <= rightArray[q])) {
                result[i] = leftArray[p++];
            } else {
                result[i] = rightArray[q++];
            }
        }
        return result;
    }


}
