package dp.knapsack;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/4 10:27
 * @Version 1.0
 * @Description 使用动态规划 计算 0-1背包
 */
public class KnapsackProblemDP {

    //体积 volume[i]表示第i件商品的价格
    int[] volume;

    //价格 price[i]表示第i件商品的价格
    int[] price;

    //背包容量
    int maxVolume;

    //计算dp
    int[][] dp;
    //辅助备忘录数组 用于回溯寻找解
    int[][] rec;

    /**
     * 从第0-i件物品可选取 、背包剩余容积为c的条件下能获得的最大总价值
     */
    public int KnapsackDP() {
        for (int i = 1; i <= volume.length; i++) {
            for (int j = 1; j <= maxVolume; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= volume[i - 1]) {
                    //选择第i件
                    int pr = dp[i - 1][j - volume[i - 1]] + price[i - 1];
                    if (pr > dp[i][j]) {
                        dp[i][j] = pr;
                        rec[i][j] = 1;
                    }
                }
            }
        }
        backtrack();
        return dp[volume.length][maxVolume];
    }


    /*回溯找到最优解对应的物品选择*/
    private void backtrack() {
        int n = price.length;
        int max = maxVolume;
        while (n > 0) {
            if (rec[n][max] == 1) {
                System.out.println("选择了第:" + n + "件物品");
                max -= volume[n - 1];
            } else {
                System.out.println("没有选择第:" + n + "件物品");
            }
            n--;
        }
    }

    public void init(int[] volume, int[] price, int maxVolume) {
        this.volume = volume;
        this.price = price;
        this.maxVolume = maxVolume;
        this.dp = new int[volume.length + 1][maxVolume + 1];
        this.rec = new int[volume.length + 1][maxVolume + 1];
    }
}
