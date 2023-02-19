package day23;

import java.io.*;
import java.util.Scanner;

/**
 * 组合数暴力解法
 * 30分，存在除0异常
 * *********/
public class P2822 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static long t,k,n,m,ans;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        t = in.nextLong();
        k = in.nextLong();

        while (t-- != 0) {
            ans = 0;
            n = in.nextLong();
            m = in.nextLong();
            for (long i = 0; i <= n; i++) {
                for (long j = 0; j <= Math.min(m, i); j++) {
                    if (C(i,j)%k==0)
                        ans++;
                }
            }
            out.println(ans);
        }
        out.flush();

    }

    // 计算组合数
    public static long C(long n, long m) {
        return ck(n) / (ck(m)*ck(n-m));
    }

    // 计算阶乘
    public static long ck(long x) {
        if (x == 0) return 1;
        int sum = 1;
        for (long i = 1; i <= x; i++) {
            sum *= i;
        }
        return sum;
    }
}
