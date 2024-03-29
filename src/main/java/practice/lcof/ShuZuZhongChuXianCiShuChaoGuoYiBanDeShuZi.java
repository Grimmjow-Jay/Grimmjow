package practice.lcof;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 *
 * <pre>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 * 限制：
 * 1 <= 数组长度 <= 50000
 * </pre>
 *
 * @author Grimm
 * @date 2021/2/23
 */
public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZi {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int majorityElement = majorityElement(nums);
        System.out.println(majorityElement);
    }

    private static int majorityElement(int[] nums) {
        int x = 0;
        int votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
