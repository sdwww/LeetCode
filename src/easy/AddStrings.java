package easy;

/**
 * 415. 字符串相加
 *
 * @author www
 */
public class AddStrings {

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        String s = addStrings.addStrings("1", "99999999");
        System.out.println(s);
    }

    public String addStrings(String num1, String num2) {
        // 倒转字符串
        StringBuilder reverseNum1 = new StringBuilder(num1).reverse();
        StringBuilder reverseNum2 = new StringBuilder(num2).reverse();
        int length = Math.max(num1.length(), num2.length());
        // 补零对齐
        if (reverseNum1.length() < length) {
            for (int i = 0; i < length - num1.length(); i++) {
                reverseNum1.append("0");
            }
        } else {
            for (int i = 0; i < length - num2.length(); i++) {
                reverseNum2.append("0");
            }
        }
        boolean addOne = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int sum = Integer.parseInt(reverseNum1.substring(i, i + 1)) + Integer.parseInt(reverseNum2.substring(i, i + 1));
            int temp = sum + (addOne ? 1 : 0);
            if (temp >= 10) {
                result.append(temp - 10);
                addOne = true;
            } else {
                result.append(temp);
                addOne = false;
            }
        }
        // 最后可能向上进1
        if (addOne) {
            result.append("1");
        }
        return result.reverse().toString();
    }
}