package day24;

import java.util.Scanner;

public class lq2022_E_求阶乘 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();

        long l = 1, r = 4011686018427387000l;
        while (l <= r) {
            long mid = (l + r) >> 1;
            // 必须是5的倍数
            if (check(mid, k) == 0) {
                if (mid % 5 == 0) {
                    System.out.println(mid);
                    break;
                } else {
                    r = mid-1;
                }
            } else if (check(mid, k) == 1) {
                r = mid - 1;
            } else if (check(mid, k) == -1) {
                l = mid + 1;
            }
        }
        if (l > r)
            System.out.println(-1);
    }

    public static int check(long x, long k) {
        long cnt = 0;

        while (x > 0) {
            x /= 5;
            cnt += x;
        }

        if (cnt == k)
            return 0; //正解
        else if (cnt > k)
            return 1; //x需要更小
        else
            return -1;//x需要更大
    }
}
