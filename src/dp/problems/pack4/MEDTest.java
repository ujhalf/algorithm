package dp.problems.pack4;

import org.junit.Test;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/5 11:33
 * @Version 1.0
 * @Description
 */
public class MEDTest {
    String str1 = "ABCBDAB";
    //             ABCBDNBA
    String str2 = "BDCAFNBA";

    @Test
    public void test() {
        MinimumEditDistance minimumEditDistance = new MinimumEditDistance();
        minimumEditDistance.init(str1,str2);
        minimumEditDistance.solve();
    }
}
