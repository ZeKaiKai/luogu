package day9;

import java.util.Scanner;

public class P1990 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] f = new int[1000010];
        int[] g = new int[1000010];
        // f[n] = f[n-1] + f[n-2] + 2*g[n-2]
        // g[n] = g[n-1] + f[n-1]
         f[0] = 1;
         g[1] = f[1] = 1;


        for (int i = 2; i <= N; i++) {
            f[i] = ((f[i-1] + f[i-2])%10000 + 2*g[i-2]%10000) % 10000;
            g[i] = (g[i-1] + f[i-1]) % 10000;
        }

        System.out.println(f[N]);
    }
}
