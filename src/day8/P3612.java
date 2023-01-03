package day8;

import java.util.Scanner;

public class P3612 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ss = in.next();
        char[] s = ss.toCharArray();
        long n = in.nextLong();
        long num = s.length;
        long x = 0;
        while (n > num) {
            x = num;
            // 找到恰好包含当前n的串长
            while (n > x) {
                x *= 2;
            }
            // 得到当前串的一半长
            x /= 2;
            // 其在前半串中的对应位置\
            n -= (x+1);
            if (n == 0)
                n = x;
        }
        System.out.println(s[(int)n-1]);
    }
}


