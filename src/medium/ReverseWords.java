package medium;

/**
 * 151. 翻转字符串里的单词
 *
 * @author www
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String s = reverseWords.reverseWords("   a good   example");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if ("".equals(strings[i])) {
                continue;
            }
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}