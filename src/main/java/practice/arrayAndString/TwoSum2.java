package practice.arrayAndString;

/**
 * 两数之和 II - 输入有序数组
 * <pre>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * </pre>
 */
public class TwoSum2 {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = twoSum(numbers, target);
        for (int i : twoSum) {
            System.out.print(i + " ");
        }
    }

    private static int[] twoSum(int[] numbers, int target) {
        int x = 0;
        int y = numbers.length - 1;
        while (x < y) {
            int sum = numbers[x] + numbers[y];
            if (sum == target) {
                return new int[]{x + 1, y + 1};
            }
            if (sum > target) {
                y--;
            }
            if (sum < target) {
                x++;
            }
        }
        throw new IllegalArgumentException("Without answer.");
    }
}
