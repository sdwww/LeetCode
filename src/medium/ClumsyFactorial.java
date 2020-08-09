package medium;

/**
 * Copyright (C), 2018-2020 JD.COM All Right Reserved
 *
 * @author wangweiwei56
 * @date 2020/8/9 18:03
 * Description:1006. 笨阶乘
 */
public class ClumsyFactorial {

    public static void main(String[] args) {
        ClumsyFactorial solution = new ClumsyFactorial();
        System.out.println(solution.clumsy(4));
    }

    public int clumsy(int N) {
        int count = 0;
        int result = N;
        int resultTemp = 0;
        for (int i = N - 1; i > 0; i--) {
            if (count % 4 == 0) {
                if (resultTemp > 0) {
                    resultTemp *= i;
                } else {
                    result *= i;
                }
            } else if (count % 4 == 1) {
                if (resultTemp > 0) {
                    resultTemp /= i;
                } else {
                    result /= i;
                }
            } else if (count % 4 == 2) {
                result += i;
                result -= resultTemp;
                resultTemp = 0;
            } else {
                resultTemp = i;
            }
            count++;
        }
        return result - resultTemp;
    }


}
