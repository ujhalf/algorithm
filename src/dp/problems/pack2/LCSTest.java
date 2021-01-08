package dp.problems.pack2;

import org.junit.Test;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/4 16:39
 * @Version 1.0
 * @Description
 */
public class LCSTest {
    String str1 = "ABCBDAB";
    String str2 = "BDCABA";

    @Test
    public void test() {
        LongestCommonSubsequence subsequence = new LongestCommonSubsequence();
        int ans = subsequence.solve(str1, str2);
        System.out.println(ans);


    }
}
