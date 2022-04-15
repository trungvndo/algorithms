package algorithms.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTests {

    @Test
    void mergeSortTest() {
        int n = 500;
        int[] nums = new int[n];
        int[] sortedNums = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int newInt = rand.nextInt();
            nums[i] = newInt;
            sortedNums[i] = newInt;
        }
        Arrays.sort(sortedNums);
        MergeSort.sort(nums);
        Assertions.assertArrayEquals(nums, sortedNums);
    }
    @Test
    void countInversionTest() {
        int[] nums = {2,3,8,6,1};
        Assertions.assertEquals(5, MergeSort.sortAndCountInversion(nums));
    }

    @Test
    void countInversionTest2() {
        int[] nums = {2,3,8,9,4,6,1};
        Assertions.assertEquals(10, MergeSort.sortAndCountInversion(nums));
    }
}
