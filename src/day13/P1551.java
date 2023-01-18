package day13;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1551 {
    public static int MAXN = 50005;
    public static int[] fa = new int[MAXN];
    public static int[] rank = new int[MAXN];
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();

        init(n);

        for (int i = 1; i <= m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            merge(x, y);
        }

        for (int i = 0; i < p; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (find(x) == find(y)) {
                out.write("Yes\n");
            } else {
                out.write("No\n");
            }
        }
        out.flush();
        out.close();
    }

    public static void init(int n) {
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
    }

    public static int find(int x) {
        return x==fa[x] ? x : (fa[x] = find(fa[x]));
    }

    public static void merge(int i, int j) {
        int x = find(i), y = find(j);
        if (x >= y)
            fa[y] = x;
        else
            fa[x] = y;
        if (x == y && i != j)
            rank[x]++;  // 包含在第一种情况中，高度相同，则合并后高度加一
    }
}
