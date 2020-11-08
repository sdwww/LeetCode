package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 539. 最小时间差
 */
public class FindMinDifference {

    public static void main(String[] args) {
        FindMinDifference solution = new FindMinDifference();
        List<String> list = new ArrayList<>();
        list.add("00:00");
        list.add("23:59");
//        list.add("00:00");
        System.out.println(solution.findMinDifference(list));
    }

    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> times = new ArrayList<>(timePoints.size());
        for (String timePoint : timePoints) {
            int time = parseTime(timePoint);
            times.add(time);
        }
        Collections.sort(times);
        int min = 1440;
        for (int i = 0; i < times.size() - 1; i++) {
            if (times.get(i + 1) - times.get(i) < min) {
                min = times.get(i + 1) - times.get(i);
            }
        }
        return Math.min(min, times.get(0) + 1440 - times.get(times.size() - 1));
    }

    private int parseTime(String timeStr) {
        String[] timeArray = timeStr.split(":");
        return Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);
    }
}
