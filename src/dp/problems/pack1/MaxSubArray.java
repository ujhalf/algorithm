package dp.problems.pack1;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/4 15:36
 * @Version 1.0
 * @Description 使用动态规划求解最大子数组问题
 */
public class MaxSubArray {
    /**
     * 待计算的数组
     */
    int[] arr;

    /**
     * 辅助数组:记录最优解
     * rec[u]=v表示 以索引u开头的和最大的子数组的尾部索引为v
     */
    int[] rec;

    /**
     * 辅助数组:
     * dp[u]=v表示 从索引为u开始的和最大的子数组的和为v
     */
    int[] dp;

    public void solve(int[] arr) {
        init(arr);
        int N = dp.length;
        /*初始化*/
        dp[N - 1] = arr[N - 1];
        rec[N - 1] = N - 1;

        for (int i = N - 2; i >= 0; i--) {
            if (dp[i + 1] > 0) {
                dp[i] = arr[i] + dp[i + 1];
                rec[i] = rec[i + 1];
            } else {
                dp[i] = arr[i];
                rec[i] = i;
            }
        }
        bachTrack();
    }

    /**
     * 回溯寻找最优解
     */
    private void bachTrack() {
        /*回溯找到最右解的值*/
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("和最大的子数组的和为:" + dp[maxIndex]);
        System.out.println("和最大的子数组的起始下标为:" + maxIndex + "   " + rec[maxIndex]);
    }

    private void init(int[] arr) {
        this.arr = arr;
        this.rec = new int[arr.length];
        this.dp = new int[arr.length];
    }

}
