package dp.knapsack;

import java.util.Arrays;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/4 10:27
 * @Version 1.0
 * @Description 使用递归计算 0-1背包
 */
public class KnapsackProblem {

    //体积 volume[i]表示第i件商品的价格
    int[] volume;

    //价格 price[i]表示第i件商品的价格
    int[] price;


    //如何回溯 确定哪件商品选取了?

    /**
     * 从第0-i件物品可选取 、背包剩余容积为c的条件下能获得的最大总价值
     */
    public int KnapsackSR(int i, int c) {

        System.out.println("计算问题  " + i + "==" + c);

        if (c < 0) {
            return Integer.MIN_VALUE;
        }
        if (i <= -1) {
            return 0;
        }

        int p1 = KnapsackSR(i - 1, c - volume[i]) + price[i];
        int p2 = KnapsackSR(i - 1, c);
        int max = Math.max(p1, p2);

        return max;
    }


    public int KnapsackSR2(int i, int c) {

        System.out.println("计算问题  " + i + "==" + c);

        if (c <= 0) {
            return 0;
        }
        if (i <= -1) {
            return 0;
        }

        int p1 = KnapsackSR(i - 1, c - volume[i]) + price[i];
        int p2 = KnapsackSR(i - 1, c);
        int max = Math.max(p1, p2);

        return max;
    }

    public void init(int[] volume, int[] price, int maxVolume) {
        this.volume = volume;
        this.price = price;
    }
}
