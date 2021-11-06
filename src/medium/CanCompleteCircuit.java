package medium;

/**
 * 134. 加油站
 */
public class CanCompleteCircuit {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        CanCompleteCircuit solution = new CanCompleteCircuit();
        int i = solution.canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        while (i < gas.length) {
            int count = 0;
            int gasSum = 0;
            int costSum = 0;
            while (count < gas.length) {
                int index = (i + count) % gas.length;
                gasSum += gas[index];
                costSum += cost[index];
                if (costSum > gasSum) {
                    break;
                }
                count++;
            }
            if (count == gas.length) {
                return i;
            } else {
                i = i + count + 1;
            }
        }
        return -1;
    }
}
