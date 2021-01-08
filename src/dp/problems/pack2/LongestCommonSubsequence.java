package dp.problems.pack2;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/4 16:11
 * @Version 1.0
 * @Description
 */
public class LongestCommonSubsequence {
    char[] chars1;
    char[] chars2;
    int[][] dp;
    int[][] rec;
    int M;
    int N;

    public int solve(String str1, String str2) {
        init(str1, str2);
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    rec[i][j] = 3;
                } else {
                    int u = dp[i - 1][j];
                    int l = dp[i][j - 1];
                    if (u >=l) {
                        dp[i][j] = u;
                        rec[i][j] = 2;
                    } else {
                        dp[i][j] = l;
                        rec[i][j] = 1;
                    }
                }
            }
        }
//        backTrack();
//        System.out.println();
//        print();
        return dp[M][N];
    }


    private void init(String str1, String str2) {
        this.chars1 = str1.toCharArray();
        this.chars2 = str2.toCharArray();
        this.M = str1.length();
        this.N = str2.length();
        dp = new int[M + 1][N + 1];
        rec = new int[M + 1][N + 1];
    }

    /**
     * 回溯找到最优解
     */
    private void backTrack() {
        int i = M;
        int j = N;
        int max = dp[M][N];
        while (max > 0) {
            if (rec[i][j] == 3) {
                System.out.println();
                System.out.print("第一个字符串的索引为:" + (i - 1));
                System.out.print("  对应于  ");
                System.out.print("第二个字符串的索引为:" + (j - 1));
                max--;
                i--;
                j--;
            } else if (rec[i][j] == 2) {
                i--;
            }else if (rec[i][j]==1){
                j--;
            }

        }
    }

    private void print() {
        for (int i = 0; i <= M; i++) {
            System.out.println();
            for (int j = 0; j <=N; j++) {
                System.out.print(" "+rec[i][j]);
            }

        }
    }


}
