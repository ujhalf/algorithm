package dp.problems.pack1;

import org.junit.Test;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/4 16:03
 * @Version 1.0
 * @Description
 */
public class MaxSubArrayTest {
    int[] arr = {1, -2, 4, 5, -2, 8, 3, -2, 6, 3, 7, -1};

    /**
     * 测试MaxSubArray.class
     * 使用动态规划求解最大子数组问题
     */
    @Test
    public void test1() {
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.solve(arr);
    }
}
