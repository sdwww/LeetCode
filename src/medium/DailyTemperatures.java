package medium;

import java.util.Arrays;

/**
 * 739. 每日温度
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        Arrays.stream(solution.dailyTemperatures(arr)).forEach(System.out::println);
    }

    public int[] dailyTemperatures(int[] T) {
        int[] temperatures = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                temperatures[i] = 1;
            } else if (T[i] == T[i + 1] && temperatures[i + 1] > 0) {
                temperatures[i] = temperatures[i + 1] + 1;
            } else if (T[i] == T[i + 1] && temperatures[i + 1] == 0) {
                temperatures[i] = 0;
            } else {
                for (int j = i + 1; j < T.length; j++) {
                    if (T[j] > T[i]) {
                        temperatures[i] = j - i;
                        break;
                    }
                }
            }
        }
        return temperatures;
    }
}
