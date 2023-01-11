package day10;

import java.util.Scanner;

public class P5019 {
    static int[] a = new int[100005];
    static int n = 0;

    public static void main(String[] args) {
        /********选一个最小的数，再从其开始先两边尽可能宽的贪心选择区间即可********/
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int l = 0, r = 0;

        int sum = 0; // 累计天数
        while (true) {
            int min = a[0];
            int index = 0;

            // 找到第一个非0
            int ii = 0;
            for (ii = 0; ii < n; ii++) {
                if (a[ii] == 0) {
                    continue;
                }
                min = a[ii];
                index = ii;
                break;
            }

            if (ii == n) {
                //说明全是0，输出sum
                System.out.println(sum);
                return;
            }
            // 找到当前最小
            for (int i = index; i < n; i++) {
                if (a[i] < min) {
                    if (a[i] == 0) {
                        break;
                    }
                    min = a[i];
                    index = i;
                }
            }

            // 两个循环计算区间
            l = r = index;
            while (l >= 0 && a[l] != 0) {
                l--;
            }
            while (r <= n && a[r] != 0) {
                r++;
            }
            l++;
            r--; // 多算了一次，处理
            int t = a[index];
            for (int i = l; i <= r; i++) {
                a[i] -= t; // 区间内元素都减去最小值
            }
            sum += t; // 累计最小值
        }
    }
}
