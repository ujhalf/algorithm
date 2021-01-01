package graph.maximumflow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Edmonds-Karp Algorithm: an implementation of Ford-Fulkerson Algorithm
 */
public class EdmondsKarp {

    public static void main(String[] args) {
        EdmondsKarp edmondsKarp = new EdmondsKarp();
        int source = 0;
        int sink = 5;
        int[][] graph = new int[6][6];
        graph[0][1]=12;
        graph[0][2]=14;
        graph[1][3]=10;
        graph[2][1]=5;
        graph[2][3]=11;
        graph[2][4]=6;
        graph[3][4]=5;
        graph[3][5]=14;
        graph[4][5]=11;
        edmondsKarp.init(source, sink, graph);
        int i = edmondsKarp.edmons_karp();
        System.out.println(i);
    }

    private void init(int source, int sink, int[][] graph) {
        this.source = source;
        this.sink = sink;
        this.graph = graph;
        this.row = graph.length;
        visited = new boolean[row];
        pred = new int[row];
    }

    int source;
    int sink;

    //使用邻接矩阵来表示有向图
    int[][] graph;

    int row;

    /**
     * 辅助数组:记录前驱 用于还原由sink->source的路径
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

        return visited[sink];
    }

    private int edmons_karp() {
        Arrays.fill(pred, -1);

        int maxFlow = 0;

        int pathFlow = Integer.MAX_VALUE;

        while (bfs()) {
            pathFlow = Integer.MAX_VALUE;
            int s = sink;
            while (s != source) {
                pathFlow = Math.min(pathFlow, graph[pred[s]][s]);
                s = pred[s];
            }
            maxFlow += pathFlow;
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
