package greedy.kanpsack;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/6 14:45
 * @Version 1.0
 * @Description
 */
public class FractionalKnapsackProblem {

    /**
     * 输入:
     * volume[i] 第i件物品的总体积
     * price[i] 第i件物品的价格
     * capacity 总容量
     */
    int[] volume;
    int[] price;
    int capacity;

    /**
     * 记录物品总件数
     */
    int m;

    /**
     * 辅助数组:
     */
    int[][] arr;

    public void init(int[] volume, int[] price, int capacity) {
        this.volume = volume;
        this.price = price;
        this.capacity = capacity;
        this.m = volume.length;
        this.arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = price[i];
            arr[i][1] = volume[i];
        }

    }

    public int solve() {

        //按照物品的性价比排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] * o1[1] - o1[0] * o2[1];
            }
        });
        int i = 0;
        int ans = 0;
        while (capacity > 0 && i < m) {
            int v = Math.min(capacity, arr[i][1]);
            ans += arr[i][0] * v / arr[i][1];
            capacity -= v;
            i++;
        }
        return ans;
    }
}
