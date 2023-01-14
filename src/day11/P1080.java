package day11;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/*****需要证明的贪心题******/
// 考虑最简单的情况，只有一个皇帝和两个大臣，考虑他们是否交换的两种情况
    // 不交换 即求max(S/b1, S*a1/b2)
    // 交换则变为max(S/b2, S*a2/b1)
    // 显然S/b1 < S*a2/b1(因为a1是正整数)
    // 只要S*a1/b2 < S*a2/b1，那么max(S/b1, S*a1/b2) < max(S/b2, S*a2/b1)恒成立
    // 只需a1b1 < a2b2
    // 只需按照ab相乘排序即可
class a implements Comparable<a>{
    int l;
    int r;

    public a(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(a o) {
        return this.l*this.r - o.l*o.r;
    }
}

public class P1080 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        a[] a = new a[n+1];

        // a[0]是皇帝
        // a[1]-a[n]是n各大臣
        for (int i = 0; i < n + 1; i++) {
            a[i] = new a(in.nextInt(), in.nextInt());
        }

        Arrays.sort(a, 1, n+1);

        BigInteger minMax = BigInteger.ZERO;
        BigInteger S = new BigInteger(String.valueOf(a[0].l));
        BigInteger res = BigInteger.ZERO;

        for (int i = 1; i < n+1; i++) {
            res = S.divide(new BigInteger(String.valueOf(a[i].r)));
            S = S.multiply(new BigInteger(String.valueOf(a[i].l)));
            if (res.compareTo(minMax) > 0) {
                minMax = res;
            }
        }

        System.out.println(minMax);
    }
}
