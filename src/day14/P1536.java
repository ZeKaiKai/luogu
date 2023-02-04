package day14;

import java.io.*;

public class P1536 {
    public static int MAXN = 1005;
    public static int[] fa;
    public static int[] rank;
    public static StreamTokenizer in = new StreamTokenizer(new InputStreamReader(System.in));
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int next() throws IOException {
        in.nextToken();
        return (int)in.nval;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            int n = next();
            if (n == 0)
                break;
            int m = next();
            init(n);
            for (int i = 0; i < m; i++) {
                int x = next();
                int y = next();
                merge(x, y);
            }
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (i == find(i))
                    cnt++;
            }
            out.write(String.valueOf(cnt-1));
            out.write('\n');
        }
        out.flush();
    }

    public static void init(int n){
        fa = new int[n+1];
        rank = new int[n+1];
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
    }
    public static void merge(int x, int y) {
        x = find(x);
        y = find(y);
        if (rank[x] >= rank[y])
            fa[y] = x;
        else
            fa[x] = y;
        if (rank[x] == rank[y] && x != y)
            rank[x]++;
    }

    public static int find(int x) {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }
}
