package easy;

/**
 * 344. 反转字符串
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        char[] charArray = new char[]{'0', '3', '5', '9', '1', '2', '8'};
        solution.reverseString(charArray);
        System.out.println(charArray);
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}
