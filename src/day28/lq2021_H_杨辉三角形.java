package day28;

import java.util.Scanner;

public class lq2021_H_杨辉三角形 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] a = new int[10000];


        if (n==1)
            System.out.println(1);
        else {
            a[0] = a[1] = a[2] = 1;
            System.out.println(1 + "    " + 1);
            for (int i = 0; i <= n; i++) {

            }
        }

    }
}
