package dp.problems.pack5;

import org.junit.Test;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/5 16:54
 * @Version 1.0
 * @Description
 */
public class RodCuttingTest {

    int []price={0,1,5,8,9,10,17,17,20,24,24};

    int rodLen=10;

    @Test
    public void test() {
        RodCutting rodCutting = new RodCutting();
        rodCutting.init(price,rodLen);
        rodCutting.solve();
    }
}
