package greedy.activityselection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/7 21:07
 * @Version 1.0
 * @Description 活动选择问题: 有一个活动时间表，其中每个活动都有一个开始时间和结束时间，如何从中选择出最多互不冲突的活动?
 */
public class ActivitySelection {
    /**
     * 输入:
     * 活动时间表: 活动i的开始时间和结束时间分别是:  schedule[i][0] schedule[i][1]
     */
    int[][] schedule;

    List<Integer> selectedActivities;

    public List<Integer> getSelectedActivities() {
        return selectedActivities;
    }

    /**
     * 记录活动总数
     */
    int N ;

    public ActivitySelection(int[][] schedule) {
        this.schedule = schedule;
        N = schedule.length;
        this.selectedActivities = new ArrayList<>();
    }

    public int solve() {
        Arrays.sort(schedule, Comparator.comparing(a -> a[1]));
        int bound = -1;
        int i = 0;
        while (i < N) {

            while (i < N && schedule[i][0] < bound) {
                i++;
            }
            if (i < N) {
                selectedActivities.add(i);
                bound = schedule[i][1];
                i++;
            }

        }

        return selectedActivities.size();

    }
}
