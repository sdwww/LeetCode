package easy;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class CQueue {
    LinkedList<Integer> stack0;
    LinkedList<Integer> stack1;

    public CQueue() {
        stack0 = new LinkedList<>();
        stack1 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack0.push(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty()){
            if(stack0.isEmpty()){
                return -1;
            }
            while (!stack0.isEmpty()){
                stack1.push(stack0.pop());
            }
        }
        return stack1.pop();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        assert cQueue.deleteHead() == 1;
        assert cQueue.deleteHead() == 2;
        assert cQueue.deleteHead() == -1;
    }
}
