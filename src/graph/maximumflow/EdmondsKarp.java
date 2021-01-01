package graph.maximumflow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Edmonds-Karp Algorithm: an implementation of Ford-Fulkerson Algorithm
 * Ford-Fulkerson算法中并没有具体的寻找增广路的方法，Edmonds-Karp是Ford-Fulkerson的一种实现，通过BFS算法寻找增光路
 *
 * Residual Network: 残存网络，对于流网络，正向边的容量表示为剩余容量，反向边的容量为已流过的流量
 * Augmenting Path:增广路径，在残存网络中一条由源点s到汇点t的简单路径
 */
public class EdmondsKarp {

    public static void main(String[] args) {
        EdmondsKarp edmondsKarp = new EdmondsKarp();
        /*测试的流网络*/
        int source = 0;
        int sink = 5;
        int[][] graph = new int[6][6];
        graph[0][1] = 12;
        graph[0][2] = 14;
        graph[1][3] = 10;
        graph[2][1] = 5;
        graph[2][3] = 11;
        graph[2][4] = 6;
        graph[3][4] = 5;
        graph[3][5] = 14;
        graph[4][5] = 11;
        edmondsKarp.init(source, sink, graph);
        int maxFlow = edmondsKarp.edmons_karp();
        System.out.println(maxFlow);
    }

    private void init(int source, int sink, int[][] graph) {
        this.source = source;
        this.sink = sink;
        this.graph = graph;
        this.row = graph.length;
        visited = new boolean[row];
        pred = new int[row];
    }


    /**
     * 源点
     * 邻接矩阵中的索引
     */
    int source;
    /**
     * 汇点
     * 邻接矩阵中的索引
     */
    int sink;

    /**
     * 使用邻接矩阵来表示有向图
     */
    int[][] graph;

    /**
     * 邻接矩阵的维度 顶点的总数
     */
    int row;

    /**
     * 辅助数组:记录前驱 用于还原由sink->source的路径
     * pred[u]=v表示增广路径中存在由v->u的边
     */
    int[] pred;

    /**
     * 辅助数组:用于bfs遍历，记录当前节点是否访问过
     */
    boolean[] visited;


    /**
     * 辅助队列:用于bfs遍历
     */
    Queue<Integer> queue;

    /**
     * bfs遍历
     * 当残存网络中存在由source->sink的路径时返回true
     * 同时在pred数组中记录路径
     */
    private boolean bfs() {

        /*标记所有顶点为未访问*/
        Arrays.fill(visited, false);

        /*创建队列用于bfs*/
        queue = new ArrayDeque<>();

        /*源点入队并标记为已访问*/
        visited[source] = true;
        queue.offer(source);

        /*标准的bfs遍历*/
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            for (int i = 0; i < row; i++) {
                if (!visited[i] && graph[u][i] > 0) {
                    queue.offer(i);
                    visited[i] = true;
                    pred[i] = u;
                }
            }
        }

        /*当访问到汇点 证明找到了一条增广路径*/
        return visited[sink];
    }

    /**
     * 使用Edmonds-Karp算法求解最大流
     *
     * @return 最大流量
     */
    private int edmons_karp() {
        /*初始时所有顶点不存在前驱节点 标记为-1*/
        Arrays.fill(pred, -1);
        /*初始时流量为0*/
        int maxFlow = 0;

        int pathFlow = Integer.MAX_VALUE;

        /*当存在增广路时 增加最大流*/
        while (bfs()) {
            pathFlow = Integer.MAX_VALUE;
            /*由汇点回溯至源点，查询增广路径上剩余容量最小的边的容量 即为此次增广路增加的流量*/
            int s = sink;
            while (s != source) {
                pathFlow = Math.min(pathFlow, graph[pred[s]][s]);
                s = pred[s];
            }
            /*最大流的增量为增广路径上剩余容量最小的边的容量*/
            maxFlow += pathFlow;

            /*
             * 沿着增广路 更新残存网络
             * 包括：更新正向边的剩余容量 更新反向边的容量
             * */
            int v = sink;
            while (v != source) {
                int u = pred[v];
                graph[u][v] -= pathFlow;
                graph[v][u] += pathFlow;
                v = pred[v];
            }
        }
        return maxFlow;
    }
}
