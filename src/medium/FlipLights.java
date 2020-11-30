package medium;

/**
 * 672. 灯泡开关 Ⅱ
 */
public class FlipLights {

    public static void main(String[] args) {
        FlipLights solution = new FlipLights();
        System.out.println(solution.flipLights(3, 1));

    }

    public int flipLights(int n, int m) {
        if (n == 0) {
            return 0;
        }
        if (m == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            if (m > 1) {
                return 4;
            } else {
                return 3;
            }
        }
        while (m > 4) {
            m -= 2;
        }
        if (m == 4 || m == 3) {
            return 8;
        } else if (m == 2) {
            return 7;
        } else {
            return 4;
        }
    }
}
