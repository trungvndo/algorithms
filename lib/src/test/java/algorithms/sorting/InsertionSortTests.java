package algorithms.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class InsertionSortTests {

    @Test
    void insertionSortTest1() {
        int[] nums = {4,2,5,4,7,232,73,43,56};
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        InsertionSort.sort(nums);
        Assertions.assertArrayEquals(nums, sortedNums);
    }

    @Test
    void insertionSortTest2() {
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
        InsertionSort.sort(nums);
        Assertions.assertArrayEquals(nums, sortedNums);
    }
}
