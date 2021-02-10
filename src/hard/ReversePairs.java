package hard;

/**
 * 剑指 Offer 51. 数组中的逆序对
 */
public class ReversePairs {

    int count = 0;

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] nums = {7, 5, 6, 4};
//        int[] nums = {1,3,2,3,1};
        System.out.println(reversePairs.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        if (nums == null) {
            return count;
        }
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return count;
    }

    private void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        // 1.对前半部分进行排序
        mergeSort(arr, start, mid, temp);
        // 2.对后半部分进行排序
        mergeSort(arr, mid + 1, end, temp);
        // 3.对两部分进行合并
        merge(arr, start, mid, end, temp);
    }

    private void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int i = 0;
        int j = start, k = mid + 1;
        while (j <= mid && k <= end) {
            if (arr[j] <= arr[k]) {
                temp[i++] = arr[j++];
            } else {
                count += (mid - j + 1);
                temp[i++] = arr[k++];
            }
        }
        while (j <= mid) {
            temp[i++] = arr[j++];
        }
        while (k <= end) {
            temp[i++] = arr[k++];
        }

        for (int t = 0; t < i; t++) {
            arr[t + start] = temp[t];
        }
    }
}
