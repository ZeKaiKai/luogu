package day7;

import java.util.Scanner;

public class P1164 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();

        int[] a = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = in.nextInt();
        }

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] += dp[i-1][j];
                if (j >= a[i]) {
                    dp[i][j] += dp[i-1][j-a[i]];
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}
