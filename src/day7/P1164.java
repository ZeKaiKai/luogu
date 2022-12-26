package day7;

import java.util.Scanner;

public class P1164 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        int[] a = new int[110];
        for (int i = 1; i <= N; i++) {
            a[i] = in.nextInt();
        }


        int[][] dp = new int[110][10010];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (a[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                if (a[i] == j) {
                    dp[i][j] = dp[i-1][j] + 1;
                }
                if (a[i] < j) {
                    dp[i][j] = dp[i-1][j-a[i]] + dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}
