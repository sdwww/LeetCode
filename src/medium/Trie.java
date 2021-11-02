/**
 * @(#)Trie.java, 11月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * 208. 实现 Trie (前缀树)
 *
 * @author wangweiwei
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("aab");
        System.out.println(trie.search("aa"));
        System.out.println(trie.search("aab"));
        System.out.println(trie.startsWith("aa"));
        trie.insert("aabb");
        System.out.println(trie.search("aabb"));
    }

    /**
     * 子节点
     */
    private final Trie[] children;

    /**
     * 是否有单词以此节点结尾
     */
    private boolean end;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new Trie[26];
        end = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                Trie trie = new Trie();
                current.children[index] = trie;
                current = trie;
            } else {
                current = current.children[index];
            }
        }
        current.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie lastTrie = findLastTrie(word);
        return lastTrie != null && lastTrie.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie lastTrie = findLastTrie(prefix);
        return lastTrie != null;
    }

    private Trie findLastTrie(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] != null) {
                current = current.children[index];
            } else {
                return null;
            }
        }
        return current;
    }
}