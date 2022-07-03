package easy;

import java.util.Optional;

/**
 * 剑指 Offer 05. 替换空格
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        ReplaceSpace solution = new ReplaceSpace();
        System.out.println(solution.replaceSpace("We are happy."));
        System.out.println(solution.replaceSpace(null));

    }

    public String replaceSpace(String s) {
        return Optional.ofNullable(s).map(str -> str.replace(" ", "%20")).orElse(null);
    }
}
