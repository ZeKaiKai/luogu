package day8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1228 {
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        solve(x, y, 1, 1, 1 << k);
        out.flush();
    }

    // 使用a，b标记每种分治后情况下的初始位置(一开始最大时为1，1)
    public static void solve(int x, int y, int a, int b, int l) throws IOException {
        if (l == 1) {
            return;
        }
        // 下面分上下左右四种情况处理
        // 每种情况都先在中间放一个方块，缺口处对准现公主所在区域
        if (x - a < l / 2 && y - b < l / 2) {
            println(a + l / 2, b + l / 2, 1);
            solve(x, y, a, b, l / 2);
            solve(a + l / 2 - 1, b + l / 2, a, b + l / 2, l / 2);
            solve(a + l / 2, b + l / 2 - 1, a + l / 2, b, l / 2);
            solve(a + l / 2, b + l / 2, a + l / 2, b + l / 2, l / 2);
        } else if (x - a < l / 2 && y - b >= l / 2) {
            println(a + l / 2, b + l / 2 - 1, 2);
            solve(a + l / 2 - 1, b + l / 2 - 1, a, b, l / 2);
            solve(x, y, a, b + l / 2, l / 2);
            solve(a + l / 2, b + l / 2 - 1, a + l / 2, b, l / 2);
            solve(a + l / 2, b + l / 2, a + l / 2, b + l / 2, l / 2);
        } else if (x - a >= l / 2 && y - b < l / 2) {
            println(a + l / 2 - 1, b + l / 2, 3);
            solve(a + l / 2 - 1, b + l / 2 - 1, a, b, l / 2);
            solve(a + l / 2 - 1, b + l / 2, a, b + l / 2, l / 2);
            solve(x, y, a + l / 2, b, l / 2);
            solve(a + l / 2, b + l / 2, a + l / 2, b + l / 2, l / 2);
        } else {
            println(a + l / 2 - 1, b + l / 2 - 1, 4);
            solve(a + l / 2 - 1, b + l / 2 - 1, a, b, l / 2);
            solve(a + l / 2 - 1, b + l / 2, a, b + l / 2, l / 2);
            solve(a + l / 2, b + l / 2 - 1, a + l / 2, b, l / 2);
            solve(x, y, a + l / 2, b + l / 2, l / 2);
        }

    }

    private static void println(int x, int y, int t) throws IOException {
        out.write(Integer.toString(x));
        out.write(' ');
        out.write(Integer.toString(y));
        out.write(' ');
        out.write(Integer.toString(t));
        out.write("\n");
    }
}
