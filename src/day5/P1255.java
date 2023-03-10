package day5;

import java.math.BigInteger;
import java.util.Scanner;

public class P1255 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        BigInteger[] a = new BigInteger[5005];

        a[1] = BigInteger.ONE;
        a[2] = new BigInteger("2");

        if (n >= 3) {
            for (int i = 3; i <= n; i++) {
                a[i] = a[i - 1].add(a[i - 2]);
            }
        }

        System.out.println(a[n]);
    }
}
