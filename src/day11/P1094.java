package day11;

import java.util.Arrays;
import java.util.Scanner;

public class P1094 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);

        int count=0;
        int j = n-1;

        for (int i = 0; i <= j; i++) {
            // 从后向前找到第一个和小于w的数字
            while(a[i] + a[j] > w) {
                count++;
                j--;
                if (j <= i) {
                    break;
                }
            }
            j--;
            count++;
        }
        System.out.println(count);
    }
}
