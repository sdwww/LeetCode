package easy;

/**
 * 169. 多数元素
 *
 * @author www
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{1, 2, 1, 4, 1}));
    }

    /**
     * 摩尔投票
     *
     * @param nums 数组
     * @return 多数元素
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }
}