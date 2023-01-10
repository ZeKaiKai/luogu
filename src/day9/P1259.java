package day9;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1259 {
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 输出初始状态
        for (int i = 0; i < n; i++) {
            out.write('o');
        }
        for (int i = 0; i < n; i++) {
            out.write('*');
        }
        out.write("--\n");

        // 模拟规律
        for (int i = 1; i < n-3; i++) {
            for (int j = 0; j < n - i; j++) {
                out.write('o');
            }
            out.write("--");
            for (int j = 0; j < n - i; j++) {
                out.write('*');
            }
            for (int j = 0; j < i; j++) {
                out.write("o*");
            }
            out.write('\n');

            for (int j = 0; j < n - i; j++) {
                out.write('o');
            }
            for (int j = 0; j < n - i; j++) {
                out.write('*');
            }
            out.write("--");

            for (int j = 0; j < i; j++) {
                out.write("o*");
            }
            out.write('\n');
        }

        // 模拟最后五行的固定流程
        out.write("ooo--***o*");
        for (int i = 1; i < n - 3; i++) {
            out.write("o*");
        }
        out.write('\n');

        out.write("ooo*o**--*");
        for (int i = 1; i < n - 3; i++) {
            out.write("o*");
        }
        out.write('\n');

        out.write("o--*o**oo*");
        for (int i = 1; i < n - 3; i++) {
            out.write("o*");
        }
        out.write('\n');

        out.write("o*o*o*--o*");
        for (int i = 1; i < n - 3; i++) {
            out.write("o*");
        }
        out.write('\n');

        out.write("--o*o*o*o*");
        for (int i = 1; i < n - 3; i++) {
            out.write("o*");
        }
        out.write('\n');



        out.flush();
        out.close();
    }
}
