package algorithms.divide_conquer;

public class MaxSubArray {

    public static int[] findMaxSubArrayDivideConquer(int[] nums) {
        if (nums.length == 0) return nums;
        return findMaxSubArray(nums, 0, nums.length - 1);
    }

    public static int[] findMaxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return new int[] {left, right, nums[left]};
        }

        int mid = left + (right - left)  / 2;

        int[] leftResult = findMaxSubArray(nums, left, mid);
        int[] rightResult = findMaxSubArray(nums, mid+1, right);
        int[] crossOverResult = findMaxSubArrayCrossOver(nums, left, right, mid);

        if (leftResult[2] >= rightResult[2] && leftResult[2] >= crossOverResult[2]) {
            return leftResult;
        } else if (rightResult[2] >= leftResult[2] && rightResult[2] >= crossOverResult[2]){
            return rightResult;
        } else {
            return crossOverResult;
        }
    }

    private static int[] findMaxSubArrayCrossOver(int[] nums, int left, int right, int mid) {
        int leftSum = nums[mid];
        int leftIndex = mid;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftIndex = i;
            }
        }

        int rightSum = nums[mid+1];
        int rightIndex = mid+1;
        sum = 0;
        for (int i = mid+1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightIndex = i;
            }
        }

        return new int[]{leftIndex, rightIndex, leftSum + rightSum};
    }

    public static int[] findMaxSubArrayBruteForce(int[] nums) {
        if (nums.length == 0) return nums;
        int[] allSums = new int[nums.length];
        allSums[0] = nums[0];
        // initialize maxResult to first element
        int[] maxResult = new int[] {0, 0, nums[0]};
        for (int i = 1; i < nums.length; i++) {
            allSums[i] = allSums[i-1] + nums[i];
            if (maxResult[2] < allSums[i]) {
                maxResult = new int[] {0, i, allSums[i]};
            }
        }


        // loop through all possible results from index 1
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (maxResult[2] < allSums[j] - allSums[i-1]) {
                    maxResult = new int[] {i, j, allSums[j] - allSums[i-1]};
                }
            }
        }

        return maxResult;
    }
}
