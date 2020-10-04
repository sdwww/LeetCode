package easy;

/**
 * @date 2020/10/2 20:40
 * Description:剑指 Offer 17. 打印从1到最大的n位数
 */
public class PrintNumbers {

    public static void main(String[] args) {
        PrintNumbers solution = new PrintNumbers();
        int[] nums = solution.printNumbers(2);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

    public int[] printNumbers(int n) {
        int length = (int) Math.pow(10, n) - 1;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}
