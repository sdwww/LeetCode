package medium;

/**
 * 319. 灯泡开关
 */
public class BulbSwitch {

    public static void main(String[] args) {
        BulbSwitch solution = new BulbSwitch();
        long startTime = System.currentTimeMillis();
        System.out.println(solution.bulbSwitch(9999999));
        System.out.println("执行时间：" + (System.currentTimeMillis() - startTime));
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
