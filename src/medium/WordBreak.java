package medium;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 139. 单词拆分
 */
public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> list = Lists.newArrayList("apple", "pen");
        boolean b = wordBreak.wordBreak("applepenapple", list);
        System.out.println(b);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                if (i + word.length() < dp.length && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
