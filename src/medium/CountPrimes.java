/**
 * @(#)CountPrimes.java, 10月 02, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

/**
 * @author wangweiwei
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        int i = countPrimes.countPrimes(5000000);
        System.out.println(i);
    }

    public int countPrimes(int n) {
        int count = 0;
        int[] primes = new int[n];
        for (int i = 2; i < n; i++) {
            if (primes[i] == 0) {
                count++;
                // i*i超过int范围，需要单独判断
                if (i > Math.sqrt(n)) {
                    continue;
                }
                for (int j = i * i; j < n; j += i) {
                    primes[j] = 1;
                }
            }
        }
        return count;
    }
}