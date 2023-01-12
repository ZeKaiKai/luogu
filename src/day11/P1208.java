package day11;

import java.util.Arrays;
import java.util.Scanner;

class cow implements Comparable<cow> {
    int p;
    int a;

    public cow(int p, int a) {
        this.p = p;
        this.a = a;
    }

    @Override
    public int compareTo(cow o) {
        return this.p - o.p;
    }
}

public class P1208 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        cow[] a = new cow[m];

        for (int i = 0; i < m; i++) {
            a[i] = new cow(in.nextInt(), in.nextInt());
        }

        Arrays.sort(a);

        int sum = 0;
        for (cow cow : a) {
            // 找完此人还有剩余
            if (n-cow.a >= 0) {
                n -= cow.a;
                sum += cow.p * cow.a;
            } else {
                sum += n * cow.p;
                n = 0;
            }
        }

        System.out.println(sum);
    }
}
