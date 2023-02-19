package day23;

import java.io.*;
import java.util.Scanner;

/**
 * 组合数问题
 * 需要复习
 * **********/
public class P2822_ {
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int[][] c = new int[2005][2005];
    public static int[][] s = new int[2005][2005];
    public static int t, k, n, m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        k = in.nextInt();

        prepare();

        while (t-- != 0) {
            n = in.nextInt();
            m = in.nextInt();

            if (n < m) m = n;     // n<m时，ans最大到达n
            out.println(s[n][m]);
        }
        out.flush();
    }

    public static void prepare() {
        c[1][1] = 1;
        // c[n][0]必等于1
        for (int i = 0; i <= 2000; i++) {
            c[i][0] = 1;
        }
        // 遍历求解
        for (int i = 2; i <= 2000; i++) {
            for (int j = 1; j <= i; j++) {
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % k;
            }
        }
        for (int i = 2; i <= 2000; i++) {
            for (int j = 1; j <= i; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
                // 二维前缀和，矩阵和，统计前面符合题意的个数
                if (c[i][j] == 0) s[i][j] += 1;
                // 可以整除就置s[i][j]为1
            }
            // 后面n<m时，直接继承前面s[n][n]的值
            s[i][i + 1] = s[i][i];
        }
    }
}
