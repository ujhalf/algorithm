package dp.weightedactivityselection;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/8 0:23
 * @Version 1.0
 * @Description
 */
public class WeightedActivitySelection {
    int[][] schedule;
    int[] weight;

    public WeightedActivitySelection(int[][] schedule, int[] weight) {
        this.schedule = schedule;
        this.weight = weight;
    }

    int N;

    /**
     * 辅助数组: pred[u]表示活动u开始前 最晚结束的活动
     */
    int[] pred;

    /**
     * dp[u]表示前u个活动能取得的最大收益
     */

    int[] dp;

    /**
     * 辅助数组:记录活动的结束时间
     */
    int[] temp;

    /**
     * 记录选择结果
     */
    int[] rec;

    public void solve() {

      //  Arrays.sort(schedule, Comparator.comparing(a -> a[1]));

        this.N = schedule.length;
        pred = new int[N + 1];
        temp = new int[N + 1];
        rec = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            temp[i] = schedule[i - 1][1];
        }
        for (int i = 1; i <= N; i++) {
            pred[i] = binarySearch(temp, 0, i - 1, schedule[i - 1][0]);
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1];
            if (dp[pred[i]] + weight[i - 1] > dp[i]) {
                rec[i] = 1;
                dp[i] = dp[pred[i]] + weight[i - 1];
            }
        }

        backrack();


    }

    private void backrack() {

        System.out.println("pred数组如下:");
        for (int i = 0; i < pred.length; i++) {
            System.out.print(pred[i] + " ");
        }
        System.out.println();
        System.out.println("最大收益为: " + dp[N]);
        System.out.println("对应的活动如下:");
        int cur = N;

        while (cur > 0) {
            if (rec[cur] == 1) {
                System.out.println("选择了"+cur);
                cur=pred[cur];
            }else {
                cur--;
            }
        }
    }


    // 二分查找 在[L,R]区间内找到索引最大的不大于target的数
    private int binarySearch(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >> 1;
            int midVal = arr[mid];
            if (midVal > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}
