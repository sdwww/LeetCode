import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10()
 */
public class Rand10 {
    public static void main(String[] args) {
        Rand10 solution = new Rand10();
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.rand9());
        }
    }

    public int rand10() {
        int random = (rand7() - 1) * 7 + rand7();
        while (random > 40) {
            random = (rand7() - 1) * 7 + rand7();
        }
        return (random - 1) / 4 + 1;

    }

    public int rand9() {
        int random = (rand7() - 1) * 7 + rand7();
        while (random > 45) {
            random = (rand7() - 1) * 7 + rand7();
        }
        return (random - 1) / 5 + 1;

    }

    private int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}
