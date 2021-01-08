package dp.problems.pack5;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/5 15:24
 * @Version 1.0
 * @Description 钢条切割问题  区间动态规划
 * 有一段长度为rodLen的钢条，不同长度的钢条其价值可能也不一样，长度为i的钢条价值为price[i] 如何切割使得总价值最大
 */
public class RodCutting {
    /**
     * 输入:price[i]长度为i的钢条的价值
     */
    int[] price;

    /**
     * 输入:待切割钢条的总长度
     */
    int rodLen;

    /**
     * dp[u]表示当钢条长度为u时 能达到的最大价值
     */
    int[] dp;
    /***
     * rec[u]表示在长度为u的钢条取得最大价值时 的切割位置
     */
    int[] rec;

    /**
     * 初始化:
     * 输入钢条长度和价值的对应关系
     * 输入待切割钢条的长度
     */
    public void init(int[] price, int rodLen) {
        this.price=price;
        this.rodLen = rodLen;
        this.dp = new int[rodLen + 1];
        this.rec = new int[rodLen + 1];
    }

    public int solve() {

        for (int i = 1; i <= rodLen; i++) {
            //不切的价值
            dp[i] = price[i];
            rec[i] = i;
            for (int j = 1; j < i; j++) {
                if (dp[j] + price[i - j] > dp[i]) {
                    dp[i] = dp[j] + price[i - j];
                    rec[i] = i - j;
                }
            }
        }
        backTrack();
        return dp[rodLen];

    }

    /**
     * 回溯 找到取得最大价值时的切割方案
     */
    public void backTrack() {
        List<Integer> ans = new ArrayList<>();

        int p = rodLen;

        while (rec[p] != p) {
            ans.add(rec[p]);
            p -= rec[p];
        }
        ans.add(rec[p]);

        System.out.println("切割最大价值为:" + dp[rodLen]);
        System.out.println("对应的切割方案为: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");

        }

    }
}
