package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 */
public class SingleNumberTwo {

    public static void main(String[] args) {
        SingleNumberTwo solution = new SingleNumberTwo();
        int[] nums = {0, 1, 0, 0, 99, 99, 99};
        System.out.println(solution.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Byte> map = new HashMap<>();
        for (int num : nums) {
            Byte value = map.get(num);
            if (value != null) {
                map.put(num, (byte) (value + 1));
            } else {
                map.put(num, (byte) 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return 0;
    }
}
