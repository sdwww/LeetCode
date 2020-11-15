package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1029. 两地调度
 */
public class TwoCitySchedCost {

    public static void main(String[] args) {
        TwoCitySchedCost solution = new TwoCitySchedCost();
        int[][] array = {{518, 518}, {71, 971}, {121, 862}, {967, 607}, {138, 754}, {513, 337}, {499, 873}, {337, 387}, {647, 917}, {76, 417}};
        System.out.println(solution.twoCitySchedCost(array));
    }

    public int twoCitySchedCost(int[][] costs) {
        int cost = 0;
        int[] difference = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            cost += costs[i][0];
            difference[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(difference);
        for(int i=0;i<costs.length/2;i++){
            cost+=difference[i];
        }
        return cost;
    }

    public int twoCitySchedCost1(int[][] costs) {
        int count = 0;
        int cost = 0;
        List<Integer> leftBig = new ArrayList<>();
        List<Integer> rightBig = new ArrayList<>();
        for (int[] ints : costs) {
            if (ints[0] < ints[1]) {
                count++;
                cost += ints[0];
                rightBig.add(ints[1] - ints[0]);
            } else {
                cost += ints[1];
                leftBig.add(ints[0] - ints[1]);
            }
        }
        leftBig.sort(Integer::compareTo);
        rightBig.sort(Integer::compareTo);
        if (count > (costs.length / 2)) {
            for (int i = 0; count > costs.length / 2; i++, count--) {
                cost += rightBig.get(i);
            }
        } else {
            for (int i = 0; count < costs.length / 2; i++, count++) {
                cost += leftBig.get(i);
            }
        }
        return cost;
    }
}
