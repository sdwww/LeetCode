package medium;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 17. 电话号码的字母组合
 *
 * @author www
 */
public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations solution = new LetterCombinations();
        List<String> list = solution.letterCombinations("223456");
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new CopyOnWriteArrayList<>();
        // 放入一个空串，方便后续处理
        if (digits.length() > 0) {
            list.add("");
        }
        for (int i = 0; i < digits.length(); i++) {
            String letters = getLetters(digits.charAt(i));
            // 基于 CopyOnWriteArrayList 迭代器的弱一致性
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String item = iterator.next();
                for (int j = 0; j < letters.length(); j++) {
                    list.add(item + letters.charAt(j));
                }
                list.remove(item);
            }
        }
        return list;
    }

    private String getLetters(char digit) {
        switch (digit) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}