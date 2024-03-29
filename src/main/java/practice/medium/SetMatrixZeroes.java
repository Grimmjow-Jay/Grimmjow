package practice.medium;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 *
 * <pre>
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * 示例 1：
 * 输入：matrix =
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * 输出：
 * [[1,0,1],
 *  [0,0,0],
 *  [1,0,1]]
 *
 * 示例 2：
 * 输入：matrix =
 * [[0,1,2,0],
 *  [3,4,5,2],
 *  [1,3,1,5]]
 * 输出：
 * [[0,0,0,0],
 *  [0,4,5,0],
 *  [0,3,1,0]]
 *  
 * 提示：
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -23^1 <= matrix[i][j] <= 23^1 - 1
 *
 * </pre>
 *
 * @author Grimm
 * @date 2021/3/27
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

}
