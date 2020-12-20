package easy;

/**
 * 744. 寻找比目标字母大的最小字母
 */
public class NextGreatestLetter {
    public static void main(String[] args) {
        NextGreatestLetter solution = new NextGreatestLetter();
        char d = solution.nextGreatestLetter(new char[]{'d', 'd', 'd'}, 'd');
        System.out.println(d);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int length = 26;
        for (char letter : letters) {
            if (letter > target && letter - target < length) {
                length = letter - target;
            } else if (letter < target && letter + 26 - target < length) {
                length = letter + 26 - target;
            }
            if (length == 1) {
                break;
            }
        }
        if (target + length > 122) {
            return (char) (target + length - 26);
        }
        return (char) (target + length);
    }
}
