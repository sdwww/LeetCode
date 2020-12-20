package medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 */
class LRUCache1 {

    private HashMap<Integer, Node> hashMap = new HashMap<>();

    private LinkedList<Node> list = new LinkedList<>();

    private int capacity;

    private static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return -1;
        }
        list.removeFirstOccurrence(node);
        list.add(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (node != null) {
            node.value = value;
            list.removeFirstOccurrence(node);
            list.add(node);
        } else {
            node = new Node(key, value);
            list.add(node);
            if (list.size() > capacity) {
                Node removeNode = list.removeFirst();
                hashMap.remove(removeNode.key);
            }
            hashMap.put(key, node);
        }
    }
}

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }


    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        // 缓存是 {1=1}
        lRUCache.put(1, 1);
        // 缓存是 {1=1, 2=2}
        lRUCache.put(2, 2);
        // 返回 1
        System.out.println(lRUCache.get(1));
        // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(3, 3);
        // 返回 -1 (未找到)
        System.out.println(lRUCache.get(2));
        // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.put(4, 4);
        // 返回 -1 (未找到)
        System.out.println(lRUCache.get(1));
        // 返回 3
        System.out.println(lRUCache.get(3));
        // 返回 4
        System.out.println(lRUCache.get(4));
    }
}
