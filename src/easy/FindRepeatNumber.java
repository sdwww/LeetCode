package easy;

/**
 * 剑指 Offer 03. 数组中重复的数字
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        FindRepeatNumber solution = new FindRepeatNumber();
        System.out.println(solution.findRepeatNumber(new int[]{0, 1, 2, 2, 2, 2}));
    }

    public int findRepeatNumber(int[] nums) {
        int[] counts = new int[nums.length];
        for (int num : nums) {
            counts[num]++;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 1) {
                return i;
            }
        }
        return 0;
    }
}
