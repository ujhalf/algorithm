package graph.bipartite;

/**
 * @Author Hui-min Lu
 * @Date 2020/12/31 16:58
 * @Version 1.0
 * @Description
 */
public class HungarianTest {
    public static void main(String[] args) {
        int[] L = {0, 1, 2, 3, 4};
        int[] R = {0, 1, 2, 3, 4};
        int[][] edges = new int[5][5];
        edges[0][1] = 1;
        edges[1][0] = 1;
        edges[1][2] = 1;
        edges[1][4] = 1;
        edges[2][0] = 1;
        edges[2][3] = 1;
        edges[3][2] = 1;
        edges[4][3] = 1;
        Hungarian hungarian = new Hungarian();
        hungarian.hungarian(L, R, edges);

    }
}
