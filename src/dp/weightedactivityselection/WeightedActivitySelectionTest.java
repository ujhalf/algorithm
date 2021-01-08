package dp.weightedactivityselection;

import greedy.activityselection.ActivitySelection;
import org.junit.Test;

import java.util.List;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/8 13:48
 * @Version 1.0
 * @Description
 */
public class WeightedActivitySelectionTest {
    int[] weight = {1, 6, 4, 7, 3, 12, 2, 9, 11, 8};

    int[][] schedule = {{1, 4}, {3, 5}, {0, 6}, {4, 7}, {3, 9}, {5, 9}, {6, 10}, {8, 11}, {8, 12}, {2, 14}};

    @Test
    public void test() {
        WeightedActivitySelection activitySelection = new WeightedActivitySelection(schedule,weight);
       activitySelection.solve();

    }

    /**
     * 测试二分查找
     */
    int[] ar = {1, 1, 2, 2, 2, 4, 4, 7, 7, 7, 9,  9, 10};

    @Test
    public void testBinarySearch() {
        int i = WeightedActivitySelectionTest.binarySearch(ar, 0, 12, 4);
        System.out.println(i);
    }

    // 二分查找 在[L,R]区间内找到索引最大的不大于target的数
    private static int binarySearch(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >> 1;
            int midVal = arr[mid];
            if (midVal > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}
