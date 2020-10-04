package medium;

import java.util.Arrays;

/**
 * @date 2020/8/15 15:50
 * Description:781. 森林中的兔子
 */
public class NumRabbits {
    public static void main(String[] args) {
        NumRabbits solution = new NumRabbits();
        int[] arr = {1, 1, 0, 0, 0};
        System.out.println(solution.numRabbits(arr));
    }

    public int numRabbits(int[] answers) {
        if (answers.length == 0) {
            return 0;
        }
        Arrays.sort(answers);
        int num = answers[0] + 1;
        int count = 1;
        for (int i = 1; i < answers.length; i++) {
            if (answers[i] > answers[i - 1] || count > answers[i]) {
                num = num + answers[i] + 1;
                count = 1;
            } else {
                count++;
            }
        }
        return num;
    }

}
