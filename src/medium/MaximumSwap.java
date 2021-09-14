package medium;

/**
 * 670. 最大交换
 *
 * @author wangweiwei
 */
public class MaximumSwap {

    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();
        int i = maximumSwap.maximumSwap(1993);
        System.out.println(i);
    }

    // 找到一个在这一位后面的最大的数，进行交换
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char max = chars[i];
            int maxIndex = i;
            for (int j = i + 1; j < chars.length; j++) {
                // 核心逻辑，如果存在相同的数，取右边的
                if (chars[j] >= max) {
                    max = chars[j];
                    maxIndex = j;
                }
            }
            if (max > chars[i]) {
                swap(chars, i, maxIndex);
                return Integer.parseInt(String.valueOf(chars));
            }
        }
        return num;
    }

    private void swap(char[] chars, int source, int target) {
        char temp = chars[source];
        chars[source] = chars[target];
        chars[target] = temp;
    }
}