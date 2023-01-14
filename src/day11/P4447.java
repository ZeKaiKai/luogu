package day11;

import java.util.Arrays;
import java.util.Scanner;

public class P4447 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        long[] q = new long[n + 1]; // 记录每个组的状态
        long[] s = new long[n + 1]; // 记录每个组的数的数量
        int t = 0; // 记录组的数量

        for (int i = 1; i <= n; i++)
            a[i] = in.nextInt();

        Arrays.sort(a, 1, n+1); //从第二个开始记录的，且后面的0不参与排序

        q[0] = a[1] + 1; //初始化，表示下一个数的值
        s[0] = 1;

        for (int i = 2; i <= n; i++) {
            // 二分查找分组，l、r是状态数组的边界
            int l = 0, r = t;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (a[i] > q[mid])
                    l = mid + 1;
                else if (a[i] < q[mid])
                    r = mid - 1;
                else
                    l = mid;
            }
            if (q[l] != a[i]) {
                s[++t] = 1;
                q[t] = a[i] + 1;
            } else {
                s[l]++;
                q[l]++;
            }
        }

        long res = s[0];
        for (int i = 1; i <= t; i++) {
            res = res > s[i] ? s[i] : res;
        }

        System.out.println(res);
    }
}
