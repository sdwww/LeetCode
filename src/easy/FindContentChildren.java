package easy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class FindContentChildren {

    public static void main(String[] args) {
        FindContentChildren solution = new FindContentChildren();
        System.out.println(solution.findContentChildren(new int[]{-1, 0, 3, 5, 9, 12}, new int[]{-1, 0, 3, 5, 9, 12}));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (g[index] <= s[i]) {
                index++;
            }
            if (index >= g.length) {
                break;
            }
        }
        return index;
    }
}
