package dp.problems.pack6;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/5 22:02
 * @Version 1.0
 * @Description 区间型动态规划：矩阵链相乘
 */
public class MatrixChainMultiplication {
    int[] matrixChain;

    /**
     * dp[i][j]表示 Ui*Ui+1*ui+2*……*Uj的最小乘法次数
     */
    int[][] dp;
    /**
     * 记录取得最小操作次数时 每一步操作 执行的是哪两个矩阵链相乘
     */
    int[][] rec;

    /**
     * 记录矩阵的总数
     */
    int M;

    public void init(int[] matrixChain) {
        this.matrixChain = matrixChain;
        this.M = matrixChain.length - 1;
        this.dp = new int[M + 1][M + 1];
        this.rec = new int[M + 1][M + 1];
    }

    public int solve() {

        /*一个矩阵 不存在相乘问题 相乘操作次数为0*/
        for (int i = 1; i <= M; i++) {
            dp[i][i] = 0;
        }
        /*
         *
         *依次枚举两个矩阵相乘 三个矩阵相乘……n个矩阵相乘
         * */
        for (int gap = 1; gap < M; gap++) {
            for (int j = 1; j + gap <= M; j++) {
                dp[j][j + gap] = Integer.MAX_VALUE;
                for (int k = 0; k < gap; k++) {
                    int cur = dp[j][j + k] + dp[j + k + 1][j + gap] + matrixChain[j - 1] * matrixChain[j + k] * matrixChain[j + gap];
                    if (cur < dp[j][j + gap]) {
                        dp[j][j + gap] = cur;
                        rec[j][j + gap] = k;
                    }
                }
            }
        }
        backtrack();
        return dp[1][M];
    }

    /**
     * 回溯寻找最优解对应的乘法先后关系
     */
    private void backtrack() {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, M});
        String ans = "U1U2U3U4U5U6";
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                System.out.println("计算问题: " + cur[0] + cur[1]);


                if (cur[0] == cur[1]) {
                    System.out.println("单个矩阵不需要考虑先后顺序");
                } else {
                    int pos = cur[0] + rec[cur[0]][cur[1]];
                    System.out.println("需要分成两个子问题相乘: 分别是:");
                    System.out.print("问题1: " + cur[0] + pos);
                    System.out.println("  问题2: " + (pos + 1) + cur[1]);
                    queue.offer(new int[]{cur[0], pos});
                    queue.offer(new int[]{pos + 1, cur[1]});
                    if (cur[0] != pos) {
                        ans = addBracketPair(ans, cur[0], true);
                        System.out.println(ans);
                        ans = addBracketPair(ans, pos, false);
                        System.out.println(ans);
                    }
                    if (pos + 1 != cur[1]) {
                        ans = addBracketPair(ans, pos + 1, true);
                        System.out.println(ans);
                        ans = addBracketPair(ans, cur[1], false);
                        System.out.println(ans);
                    }
                }
            }

        }
        System.out.println(ans);


    }

    String addBracketPair(String source, int pos, boolean isLeft) {
        String strPos = String.valueOf(pos);
        if (isLeft) {
            return source.replaceFirst("U" + strPos, "(" + "U" + strPos);
        } else {
            return source.replaceFirst(strPos, strPos + ")");
        }
    }
}
