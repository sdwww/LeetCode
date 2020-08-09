package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 260. 只出现一次的数字 III
 */
public class SingleNumberThree {

    public static void main(String[] args) {
        SingleNumberThree solution = new SingleNumberThree();
        int[] arr = {1, 2, 1, 3, 2, 5};
        int[] newArray = solution.singleNumber(arr);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }

    }

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] keys = new int[2];
        for (int num : nums) {
            Integer value = hashMap.get(num);
            if (value == null) {
                hashMap.put(num, 1);
            } else {
                hashMap.remove(num);
            }
        }
        int count = 0;
        for (Integer key : hashMap.keySet()) {
            keys[count] = key;
            count++;
        }
        return keys;
    }
}
