package day33_lq2018;

import java.util.Scanner;

public class 蜂巢 {
    static class Pair {
        double x;
        double y;

        Pair(double a, double b) {
            x = a;
            y = b;
        }
    }

    // 关键点1，描述状态的转移
    public static double[][] moves = {
            {-1, 0},
            {-0.5, 1},
            {0.5, 1},
            {1.0, 0},
            {0.5, -1},
            {-0.5, -1}
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Pair o = new Pair(0, 0);
        Pair b = new Pair(0, 0);
        Pair c = new Pair(0, 0);

        for (int i = 0; i < n; i++) {
            int d1 = in.nextInt();
            int p1 = in.nextInt();
            int q1 = in.nextInt();
            int d2 = in.nextInt();
            int p2 = in.nextInt();
            int q2 = in.nextInt();

            b.x = o.x + p1 * moves[d1][0] + q1 * moves[(d1 + 2) % 6][0];
            b.y = o.y + p1 * moves[d1][1] + q1 * moves[(d1 + 2) % 6][1];

            c.x = o.x + p2 * moves[d2][0] + q2 * moves[(d2 + 2) % 6][0];
            c.y = o.y + p2 * moves[d2][1] + q2 * moves[(d2 + 2) % 6][1];
        }

        System.out.println((int)distance(b, c));
    }

    // 计算从a走到b的最短距离
    public static double distance(Pair a, Pair b) {
        double y = Math.abs(a.y - b.y);
        double x = Math.abs(a.x - b.x);
        // 要点2，观察移动得出规律
        return y + x - y/2;
    }
}