package hard;

/**
 * @date 2020/8/9 10:34
 * Description:4. 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] arr1 = {1, 3,4};
        int[] arr2 = {};
        System.out.println(solution.findMedianSortedArrays(arr1, arr2));
    }
    // 时间复杂度 O(M+N),不满足题意
    @Deprecated
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int current = 0;
        int last = 0;
        int count = (nums1.length + nums2.length) / 2;
        while (count >= 0) {
            last = current;
            if (index2 >= nums2.length || (index1 < nums1.length && nums1[index1] < nums2[index2])) {
                current = nums1[index1];
                index1++;
            } else {
                current = nums2[index2];
                index2++;
            }
            count--;
        }

        if ((nums1.length + nums2.length) % 2 == 1) {
            return current;
        } else {
            return (double)(current + last) / 2;
        }
    }
}
