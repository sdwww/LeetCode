package medium;

/**
 * 443. 压缩字符串
 */
public class CompressString {

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        CompressString solution = new CompressString();
        int compress = solution.compress(chars);
        System.out.println(compress);
    }

    public int compress(char[] chars) {
        char current = chars[0];
        int count = 0;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (current == chars[i]) {
                count++;
            } else {
                chars[result++] = current;
                result = fillCount(chars, count, result);
                current = chars[i];
                count = 1;
            }
        }
        chars[result++] = current;
        return fillCount(chars, count, result);
    }

    // 补全数字部分
    private int fillCount(char[] chars, int count, int result) {
        if (count == 1) {
            return result;
        }
        char[] countToChar = String.valueOf(count).toCharArray();
        for (int j = 0; j < countToChar.length; j++) {
            chars[result + j] = countToChar[j];
        }
        return result + countToChar.length;
    }
}
