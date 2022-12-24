package day6;

import java.util.ArrayList;
import java.util.Scanner;

public class P1464 {
    public static long[][][] res = new long[10][10][10];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();

        while (true) {
            String s = in.nextLine();
            if ("-1 -1 -1".equals(s)) {
                break;
            } else {
                strings.add(s);
            }
        }

        int[] a = new int[3];
        for (String s : strings) {
            String[] split = s.split(" ");
            for (int i = 0; i < 3; i++) {
                a[i] = Integer.valueOf(split[i]);
            }
            System.out.print("w(");
            System.out.print(s);
            System.out.print(") = ");
            if (a[0] < 0 || a[1] < 0 || a[2] < 0){
                System.out.println(1);
            } else {
                System.out.println(w(a[0], a[1], a[2]));
            }
        }
    }

    public static Long w(int a, int b, int c) {
        if (res[a][b][c] != 0) {
            return res[a][b][c];
        }

        if (a == 0 || b == 0 || c == 0) {
            res[a][b][c] = 1;
        } else if (a > 20 || b > 20 || c > 20) {
            res[a][b][c] = w(20, 20, 20);
        } else if (a < b && b < c) {
            res[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            res[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return res[a][b][c];
    }
}
