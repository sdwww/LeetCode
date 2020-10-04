package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 2020/8/9 14:07
 * Description:119. 杨辉三角 II
 */
public class YanghuiTriangleTwo {
    public static void main(String[] args) {
        YanghuiTriangleTwo solution = new YanghuiTriangleTwo();
        System.out.println(solution.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastList;
        List<Integer> currentList = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            lastList = currentList;
            currentList = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                if (j > 0 && j < i) {
                    currentList.add(lastList.get(j - 1) + lastList.get(j));
                } else {
                    currentList.add(1);
                }
            }
        }
        return currentList;
    }
}
