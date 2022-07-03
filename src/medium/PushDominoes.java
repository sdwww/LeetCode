package medium;

/**
 * 838. 推多米诺
 */
public class PushDominoes {

    public static void main(String[] args) {
        PushDominoes solution = new PushDominoes();
        System.out.println(solution.pushDominoes(".L.R...LR..L.."));
        System.out.println(solution.pushDominoes("RR.L"));
        System.out.println(solution.pushDominoes("R.......L.R........."));
        System.out.println(solution.pushDominoes("L.....RR.RL.....L.R."));
    }

    public String pushDominoes(String dominoes) {
        char[] result = new char[dominoes.length()];
        int[] right = new int[dominoes.length()];
        int[] left = new int[dominoes.length()];
        int count = 0;
        boolean valid = false;
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') {
                valid = true;
                count = 0;
            } else if (valid && dominoes.charAt(i) == '.') {
                count++;
                right[i] = count;
            } else if (dominoes.charAt(i) == 'L') {
                count = 0;
                valid = false;
            }
        }
        count = 0;
        valid = false;
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                valid = true;
                count = 0;
            } else if (valid && dominoes.charAt(i) == '.') {
                count++;
                left[i] = count;
            } else if (dominoes.charAt(i) == 'R') {
                count = 0;
                valid = false;
            }
        }
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) != '.' || right[i] == left[i]) {
                result[i] = dominoes.charAt(i);
            }
            if (right[i] != 0 && (left[i] == 0 || left[i] > right[i])) {
                result[i] = 'R';
            }
            if (left[i] != 0 && (right[i] == 0 || right[i] > left[i])) {
                result[i] = 'L';
            }
        }
        return String.valueOf(result);
    }
}
