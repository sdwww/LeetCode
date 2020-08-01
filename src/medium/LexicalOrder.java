package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 */
public class LexicalOrder {

    public static void main(String[] args) {
        LexicalOrder solution = new LexicalOrder();
        System.out.println(solution.lexicalOrder(124));
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            search(list, i, n);
        }
        return list;
    }

    private void search(List<Integer> list, int num, int n) {
        if (num > n) {
            return;
        }
        list.add(num);
        num = num * 10;
        for (int i = 0; i <= 9; i++) {
            search(list, num + i, n);
        }
    }
}
