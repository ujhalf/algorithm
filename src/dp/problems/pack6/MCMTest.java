package dp.problems.pack6;

import org.junit.Test;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/5 22:11
 * @Version 1.0
 * @Description
 */
public class MCMTest {
    /**
     * 测试用例 共有6个矩阵 Ui=matrix[i-1] X matrix[i]
     * U1为 2X3的矩阵
     */
    private int[] matrixChain = {2, 3, 7, 9, 5, 2, 4};

    @Test
    public void test() {
        MatrixChainMultiplication solution = new MatrixChainMultiplication();
        solution.init(matrixChain);
        int solve = solution.solve();
        System.out.println(solve);
    }
}
