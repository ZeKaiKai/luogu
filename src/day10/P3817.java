package day10;

import java.util.Scanner;

public class P3817 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int x = in.nextInt();

        long sum = 0;

        int[] a = new int[n + 1];
        a[1] = in.nextInt();
        if (a[1] > x) {
            a[1] = x;
            sum += a[1] - x;
        }

        for (int i = 2; i <= n; i++) {
            a[i] = in.nextInt();

            if (a[i] + a[i - 1] > x) {
                sum += a[i] + a[i-1] - x;
                a[i] = x - a[i-1];
            }
        }

        System.out.println(sum);
    }
}
