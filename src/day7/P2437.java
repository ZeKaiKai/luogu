package day7;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 动态规划，递推方程f(n) = f(n-1) + f(n-2)
 */
public class P2437 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        BigInteger[] dp = new BigInteger[1010];

        dp[m] = BigInteger.ONE;
        dp[m+1] = BigInteger.ONE;
        for (int i = m+2; i <= n; i++) {
            dp[i] = dp[i-1].add(dp[i-2]);
        }

        System.out.println(dp[n]);
    }
}
