package day11;

import java.util.Arrays;
import java.util.Scanner;

public class P4995 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        Arrays.sort(a);

        long res = 0;
        int t = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            res += (a[n - i - 1] - t) * (a[n - i - 1] - t);
            res += (a[n - i - 1] - a[i]) * (a[n - i - 1] - a[i]);
            t = a[i];
        }

        System.out.println(res);
    }
}
