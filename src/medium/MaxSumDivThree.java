package medium;

import java.util.PriorityQueue;

/**
 * 1262. 可被三整除的最大和
 */
public class MaxSumDivThree {

    public static void main(String[] args) {
        MaxSumDivThree solution = new MaxSumDivThree();
        int[] arr = {1, 2, 3, 4, 4};
        System.out.println(solution.maxSumDivThree(arr));
    }


    public int maxSumDivThree(int[] nums) {
        int totalSum = 0;
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();
        for (int num : nums) {
            totalSum += num;
            if (num % 3 == 1) {
                priorityQueue1.add(num);
            }
            if (num % 3 == 2) {
                priorityQueue2.add(num);
            }
        }
        if (totalSum % 3 == 1) {
            totalSum -= sumFor1(priorityQueue1, priorityQueue2);
        }
        if (totalSum % 3 == 2) {
            totalSum -= sumFor1(priorityQueue2, priorityQueue1);
        }
        return totalSum;
    }

    private int sumFor1(PriorityQueue<Integer> priorityQueue1, PriorityQueue<Integer> priorityQueue2) {
        int sum1 = Integer.MAX_VALUE;
        int sum2 = Integer.MAX_VALUE;
        if (priorityQueue1.size() >= 1) {
            sum1 = priorityQueue1.poll();
        }
        if (priorityQueue2.size() >= 2) {
            sum2 = priorityQueue2.poll() + priorityQueue2.poll();
        }
        return Math.min(sum1, sum2);
    }
}
