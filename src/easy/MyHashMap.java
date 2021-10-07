/**
 * @(#)MyHashMap.java, 10月 07, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package easy;

import java.util.LinkedList;

/**
 * 706. 设计哈希映射
 *
 * @author wangweiwei
 */
public class MyHashMap {

    private final LinkedList<Pair>[] pairs;

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }

    public MyHashMap() {
        pairs = new LinkedList[128];
        for (int i = 0; i < 128; i++) {
            pairs[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        LinkedList<Pair> list = pairs[hash];
        for (Pair pair : list) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        list.add(new Pair(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        LinkedList<Pair> list = pairs[hash];
        for (Pair pair : list) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        LinkedList<Pair> list = pairs[hash];
        Pair removePair = null;
        for (Pair pair : list) {
            if (pair.key == key) {
                removePair = pair;
                break;
            }
        }
        if (removePair != null) {
            list.remove(removePair);
        }
    }

    private int hash(int key) {
        return key & (pairs.length - 1);
    }

    private static class Pair {
        /**
         * key
         */
        int key;
        /**
         * value
         */
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}