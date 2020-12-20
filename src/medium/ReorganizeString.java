package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 767. 重构字符串
 */
public class ReorganizeString {

    public static void main(String[] args) {
        ReorganizeString solution = new ReorganizeString();
        String abaa = solution.reorganizeString("ab");
        System.out.println(abaa);
    }

    public String reorganizeString(String S) {
        short[] counts = new short[26];
        int maxCount = 0;
        for (int i = 0; i < S.length(); i++) {
            int index= S.charAt(i) - 'a';
            counts[index]++;
            maxCount =Math.max(maxCount,counts[index]);
        }
        if (maxCount * 2 > S.length() + 1) {
            return "";
        }
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> -counts[o - 'a']));
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                priorityQueue.offer((char) (i + 'a'));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (priorityQueue.size() >= 2) {
            Character poll1 = priorityQueue.poll();
            Character poll2 = priorityQueue.poll();
            sb.append(poll1);
            sb.append(poll2);
            counts[poll1 - 'a']--;
            counts[poll2 - 'a']--;
            if (counts[poll1 - 'a'] > 0) {
                priorityQueue.offer(poll1);
            }
            if (counts[poll2 - 'a'] > 0) {
                priorityQueue.offer(poll2);
            }
        }
        if (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll());
        }
        return sb.toString();
    }
}
