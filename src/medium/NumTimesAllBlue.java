package medium;

/**
 * 1375. 灯泡开关 III
 */
public class NumTimesAllBlue {

    public static void main(String[] args) {
        NumTimesAllBlue solution = new NumTimesAllBlue();
        int[] arr = {2,1,4,3,6,5};
        System.out.println(solution.numTimesAllBlue(arr));
    }

    public int numTimesAllBlue(int[] light) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(light[i], max);
            if (max <= i + 1) {
                count++;
            }
        }
        return count;
    }
}
