package graph.bipartite;

import java.util.Arrays;

/**
 * @Author Hui-min Lu
 * @Date 2020/12/31 14:45
 * @Version 1.0
 * @Description
 */
public class Hungarian {
    int[] L;
    int[] R;

    /**
     * 辅助数组color
     * color[u]=-1 表示R中顶点u尚未匹配
     * color[u]=v (V!=-1)表示R中顶点u与L中顶点v匹配
     */
    boolean[] color;

    /**
     * 存储匹配结果  match[u]=v表示r中的顶点u与L中的顶点v匹配
     */
    int[] match;

    /**
     * 邻接矩阵
     * 记录L与R之间顶点的连接关系
     * edges[u][v]=1表示u与v之间存在边
     */
    int[][] edges;

    /**
     * 初始化
     */
    private void init(int[] L, int[] R, int[][] edges) {
        this.L = L;
        this.R = R;
        this.edges = edges;
        int M = edges.length;
        int N = edges[0].length;
        match = new int[N];
        //表示R中顶点尚未匹配
        Arrays.fill(match, -1);
        color = new boolean[N];
    }

    /***/
    public void hungarian(int[] L, int[] R, int[][] edges) {
        init(L, R, edges);
        for (int i = 0; i < edges.length; i++) {
            Arrays.fill(color, false);
            dfsFind(i);
        }
        printRes();
    }

    private void printRes() {
        System.out.println("匹配结果如下:");
        for (int i = 0; i < match.length; i++) {
            System.out.println(match[i] + "<==>" + i);
        }
    }

    /**
     * 从节点u开始是否能寻找到交替路径
     */
    private boolean dfsFind(int u) {
        for (int v = 0; v < edges[0].length; v++) {
            //二者存在边
            if (edges[u][v] == 1) {
                //i已经访问过
                if (color[v]) {
                    continue;
                }
                //防止重复搜索
                color[v] = true;
                if (match[v] == -1 || dfsFind(match[v])) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }


}
