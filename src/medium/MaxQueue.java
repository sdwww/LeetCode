package medium;

import java.util.LinkedList;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 *
 * @author www
 */
public class MaxQueue {

    // ["MaxQueue","max_value","pop_front","pop_front","push_back","push_back","push_back","pop_front","push_back","pop_front"]
    //[[],[],[],[],[94],[16],[89],[],[22],[]]
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());

        maxQueue.push_back(94);
        maxQueue.push_back(16);
        maxQueue.push_back(89);

        System.out.println(maxQueue.pop_front());

        maxQueue.push_back(22);

        System.out.println(maxQueue.pop_front());
    }

    // 队列
    private final LinkedList<Integer> queue;

    // 单调队列
    private final LinkedList<Integer> help;

    public MaxQueue() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public int max_value() {
        if (!help.isEmpty()) {
            return help.getFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        queue.add(value);
        while (!help.isEmpty() && help.getLast() < value) {
            help.pollLast();
        }
        help.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int pop = queue.pollFirst();
        if (help.getFirst() == pop) {
            help.pollFirst();
        }
        return pop;
    }
}