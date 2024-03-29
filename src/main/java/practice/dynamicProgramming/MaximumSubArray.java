package practice.dynamicProgramming;

/**
 * 最大子序和
 * <pre>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * </pre>
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);
    }

    private static int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int[] maxArray = new int[len];
        maxArray[0] = nums[0];
        for (int i = 1; i < len; i++) {
            maxArray[i] = Math.max(maxArray[i - 1], 0) + nums[i];
            max = Math.max(max, maxArray[i]);
        }
        return max;
    }

}
