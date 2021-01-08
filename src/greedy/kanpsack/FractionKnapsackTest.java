package greedy.kanpsack;

import org.junit.Test;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/6 15:41
 * @Version 1.0
 * @Description
 */
public class FractionKnapsackTest {
    int[] volume = {600, 250, 200, 100, 300};
    int[] price = {60, 10, 36, 16, 45};
    int capacity = 800;

    @Test
    public void test() {
        FractionalKnapsackProblem solution = new FractionalKnapsackProblem();
        solution.init(volume,price,capacity);
        int solve = solution.solve();
        System.out.println(solve);
    }
}
