package day32;

import java.util.Scanner;

public class 蓝桥算法提高_秘密行动 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        int[][] f = new int[n+1][2]; // 0-爬，1-跳

        f[1][0] = a[1];
        f[1][1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                f[i][0] = Math.min(f[i-1][0] + a[i], f[i-1][1] + a[i]);
                f[i][1] = Math.min(f[i-1][0], f[i-2][0]); //跳上来的，则上一步的只能是爬的，即第二维值一定为0
            }
        }

        System.out.println(Math.min(f[n][0], f[n][1]));
    }
}
