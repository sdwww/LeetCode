import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 728.自除数
 */
public class SelfDividingNumbers {
    public static void main(String[] args) {
        SelfDividingNumbers solution = new SelfDividingNumbers();
        System.out.println(solution.selfDividingNumbers(1, 22));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            int temp = i;
            int a;
            boolean b = true;
            while (temp >= 1) {
                a = temp % 10;
                temp = temp / 10;
                if (a == 0 || i % a != 0) {
                    b = false;
                }
            }
            if (b) {
                list.add(i);
            }
        }
        return list;
    }
}
