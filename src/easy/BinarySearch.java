package easy;

/**
 * 704.二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 9));
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] > target) {
            return -1;
        }
        if (nums[end] < target) {
            return -1;
        }
        while (start <= end) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            if (nums[(end + start) / 2] == target) {
                return (end + start) / 2;
            }
            if (nums[(end + start) / 2] < target) {
                start = (end + start) / 2 + 1;
            } else {
                end = (end + start) / 2 - 1;
            }
        }
        return -1;
    }
}
