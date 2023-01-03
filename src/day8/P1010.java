package day8;

import java.util.Scanner;

public class P1010 {
    public static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        search(n);
    }

    public static void search(int x) {
        System.out.print("2");
        int p=1, q=0;
        while (p <= x) {
            p *= 2;
            q++;
        }
        p /= 2;
        q--;
        if (q==0 || q==2) {
            System.out.print("(");
            System.out.print(q);
            System.out.print(")");
        }
        if (q >= 3) {
            System.out.print("(");
            search(q);
            System.out.print(")");
        }
        x -= p;
        if (x != 0) {
            System.out.print("+");
            search(x);
        }
    }
}