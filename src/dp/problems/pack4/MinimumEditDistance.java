package dp.problems.pack4;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/5 11:18
 * @Version 1.0
 * @Description  lc72https://leetcode-cn.com/problems/edit-distance/
 */
public class MinimumEditDistance {
    private String s;
    private String t;

    private int M;
    private int N;

    /**
     * dp[i][j]：s的前i个字符 经过最少多少次编辑操作 能够得到t的前j个字符
     * dp[i-1][j]+1
     * dp[i][j]= min  dp[i][j-1]+1
     * dp[i-1][j-1] +1 if s[i]!=t[j]
     * dp[i-1][j-1] +0 if s[i]=t[j]
     */
    int[][] dp;

    /**
     * 回溯找到最小编辑距离对应的每一步编辑操作
     * rec[u][v]=1 表示删除操作得到
     * rec[u][v]=2 表示添加操作得到
     * rec[u][v]=3 表示替换操作得到
     */
    int[][] rec;

    public int solve() {
        //当s的长度为0时 想要得到tj需要的操作数为t的长度 编辑操作为添加
        for (int i = 0; i <= N; i++) {
            dp[0][i] = i;
            rec[0][i] = 2;
        }

        //当t的长度为0时  由s->t 编辑操作为删除 编辑距离为s的长度
        for (int i = 0; i <= M; i++) {
            dp[i][0] = i;
            rec[i][0] = 1;
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                //当三种操作需要的编辑距离一样时  采用替换作为默认的编辑操作
                int minDis = dp[i - 1][j - 1];
                rec[i][j] = 3;
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    minDis++;
                }

                //删除操作的编辑距离更小时
                if (dp[i - 1][j] + 1 < minDis) {
                    rec[i][j] = 1;
                    minDis = dp[i - 1][j] + 1;
                }
                //添加操作的编辑距离更小时
                if (dp[i][j - 1] + 1 < minDis) {
                    rec[i][j] = 2;
                    minDis = dp[i][j - 1] + 1;

                }
                dp[i][j] = minDis;
            }

        }
        backTrack();
        return dp[M][N];
    }

    //回溯得到编辑操作
    public void backTrack() {
        System.out.println("最小的编辑距离为:" + dp[M][N]);
        System.out.println("编辑操作分别是:");
        int cnt = dp[M][N];
        int i = M;
        int j = N;
        while (cnt > 0) {
            System.out.print("第" + cnt + "步操作:  ");
            switch (rec[i][j]) {
                case 1: {
                    System.out.print("删除操作: ");
                    System.out.println("删除s的第" + i + "个字符: " + s.charAt(i - 1));
                    i--;
                }
                break;
                case 2: {
                    System.out.print("添加操作:  ");
                    System.out.println("添加t的第" + (j) + "个字符: " + t.charAt(j - 1));
                    j--;
                }
                break;

                case 3: {
                    System.out.print("替换操作: ");
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        System.out.println("无需替换");
                        cnt++;
                    } else {
                        System.out.print("将s的第" + i + "个字符 '" + s.charAt(i - 1) + " '替换为:  ");
                        System.out.println("t的第" + j + "个字符 '" + t.charAt(j - 1));

                    }
                    i--;
                    j--;
                }
                break;
                default:
            }

            cnt--;
        }
    }

    public void init(String source, String target) {
        this.s = source;
        this.t = target;
        this.M = s.length();
        this.N = t.length();
        this.dp = new int[M + 1][N + 1];
        this.rec = new int[M + 1][N + 1];
    }
}
