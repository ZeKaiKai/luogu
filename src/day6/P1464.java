package day6;

import java.util.ArrayList;
import java.util.Scanner;

public class P1464 {
    public static long[][][] res = new long[21][21][21];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));

        }

    }

    public static Long w(long a, long b, long c) {
        // 时刻注意数组越界，RUNTIMEERORR调了好久
        if (a < 0 || b < 0 || c < 0) {
            return 1l;
        } else if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 记忆化
        if (res[(int) a][(int) b][(int) c] != 0) {
            return res[(int) a][(int) b][(int) c];
        }

        // 普通搜索
        if (a == 0 || b == 0 || c == 0) {
            res[(int) a][(int) b][(int) c] = 1;
        } else if (a < b && b < c) {
            res[(int) a][(int) b][(int) c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            res[(int) a][(int) b][(int) c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return res[(int) a][(int) b][(int) c];
    }
}
