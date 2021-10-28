package medium;

/**
 * 402. 移掉 K 位数字
 */
public class RemoveKdigits {

    public static void main(String[] args) {
        RemoveKdigits removeKdigits = new RemoveKdigits();
        String s = removeKdigits.removeKdigits("101", 1);
        System.out.println(s);
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder(num);
        int index = 0;
        while (k > 0) {
            for (int i = index; i < stringBuilder.length(); i++) {
                // 找到一个比后面大得数，删除掉
                if (i < stringBuilder.length() - 1 && stringBuilder.charAt(i) <= stringBuilder.charAt(i + 1)) {
                    continue;
                }
                stringBuilder.deleteCharAt(i);
                index = Math.max(i - 1, 0);
                k--;
                break;
            }
        }
        // 去掉开头的0
        int zeroIndex = 0;
        while (stringBuilder.charAt(zeroIndex) == '0' && zeroIndex < stringBuilder.length() - 1) {
            zeroIndex++;
        }
        return stringBuilder.substring(zeroIndex);
    }
}
