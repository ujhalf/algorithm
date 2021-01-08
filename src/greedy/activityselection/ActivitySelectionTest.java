package greedy.activityselection;

import org.junit.Test;

import java.util.List;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/8 13:48
 * @Version 1.0
 * @Description
 */
public class ActivitySelectionTest {
    int[][]schedule={{1,4},{3,5},{0,6},{4,7},{3,9},{5,9},{6,10},{8,11},{8,12},{2,14},{12,16}};

    @Test
    public void test() {
        ActivitySelection activitySelection = new ActivitySelection(schedule);
        int solve = activitySelection.solve();
        System.out.println(solve);
        List<Integer> selectedActivities = activitySelection.getSelectedActivities();
        for (Integer key : selectedActivities) {
            System.out.println(key);
        }

    }
}
