package medium;

import java.util.HashMap;

/**
 * 1079. 活字印刷
 */
public class NumTilePossibilities {

    private int count = 0;

    public static void main(String[] args) {
        NumTilePossibilities solution = new NumTilePossibilities();
        System.out.println(solution.numTilePossibilities("AAB"));
    }

    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            char key = tiles.charAt(i);
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        search(hashMap);
        return count;
    }

    private void search(HashMap<Character, Integer> hashMap) {
        for (Character character : hashMap.keySet()) {
            if (hashMap.get(character) >= 1) {
                hashMap.put(character, hashMap.get(character) - 1);
                search(hashMap);
                count++;
                hashMap.put(character, hashMap.get(character) + 1);
            }
        }
    }

}
