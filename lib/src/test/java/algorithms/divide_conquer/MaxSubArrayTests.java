package algorithms.divide_conquer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class MaxSubArrayTests {

    @Test
    void testFindMaxSubArray() {
        Random random = new Random();
        int n = 500;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(100);
        }

        int[] result1 = MaxSubArray.findMaxSubArrayBruteForce(nums);
        int[] result2 = MaxSubArray.findMaxSubArrayDivideConquer(nums);
        int[] result3 = MaxSubArray.findMaxSubArrayLinearTime(nums);

        Assertions.assertEquals(result1[2], result2[2]);
        Assertions.assertEquals(result1[2], result3[2]);
    }
}
