package medium;

/**
 * 43. 字符串相乘
 */
public class StringMultiply {

    public static void main(String[] args) {
        StringMultiply solution = new StringMultiply();
        String multiply = solution.multiply("123", "456");
        System.out.println(multiply);
    }

    public String multiply(String num1, String num2) {
        String result= "";
        for (int i = 0; i < num1.length(); i++) {
            String string = num1.substring(i, i + 1);

        }
        return null;
    }

    public String multiplyOneNum(String num1, String num2) {
        return null;
    }


    private String addStrings(String num1, String num2) {
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
