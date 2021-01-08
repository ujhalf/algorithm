package dp.problems.pack3;

import org.junit.Test;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/4 16:39
 * @Version 1.0
 * @Description
 */
public class LCSTest {
    String str1 = "ABCADBB";
    String str2 = "BCEDBB";

    @Test
    public void test() {
        LongestCommonSubstring subsequence = new LongestCommonSubstring();
        subsequence.init(str1,str2);
        int ans = subsequence.solve();
        System.out.println(ans);


    }
}
