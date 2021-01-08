package dp.knapsack;

import org.junit.Test;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/4 10:45
 * @Version 1.0
 * @Description
 */
public class KnapsackProblemTest {
    int[] volume = {4, 3, 4, 5, 10};
    int[] price = {9, 2, 9, 10, 24};
    int no= volume.length-1;
    int volBound=13;
    @Test
    public void testSR() {
        KnapsackProblem knapsack = new KnapsackProblem();
        knapsack.init(volume,price,volBound);
        int maxPrice = knapsack.KnapsackSR2( no, 13);
        System.out.println(maxPrice);

    }

    @Test
    public void testDP() {
        KnapsackProblemDP knapsack = new KnapsackProblemDP();
        knapsack.init(volume,price,volBound);
        int maxPrice = knapsack.KnapsackDP( );
        System.out.println(maxPrice);

    }
}
