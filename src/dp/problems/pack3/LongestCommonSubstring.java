package dp.problems.pack3;

import java.util.Arrays;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/5 10:46
 * @Version 1.0
 * @Description
 */
public class LongestCommonSubstring {

    String str1;
    String str2;

    /**
     * dp[i][j] 以xi,yjj结尾的最长公共字串的长度
     * dp[i][j]=0  当xi!=yj时
     * dp[i][j]=dp[i-1][j-1]+1 当xi=uyj时
     */
    int[][] dp;
    int M;
    int N;
    int pmax;
    int lmax;

    public int solve() {

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] > lmax) {
                    lmax = dp[i][j];
                    pmax = i;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= M; i++) {
            ans = Math.max(ans, Arrays.stream(dp[i]).max().getAsInt());
        }
        backTrack();
        return ans;
    }

    private void backTrack() {
        System.out.println("最长公共子串的长度是:"+lmax);
        System.out.println("在第一个字符串中是: 第"+(pmax-lmax+1)+"到第"+pmax+"个字符");
    }

    public void init(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        this.M = str1.length();
        this.N = str2.length();
        this.dp = new int[M+1][N+1];
        this.pmax = -1;
        this.lmax = 0;
    }
}
