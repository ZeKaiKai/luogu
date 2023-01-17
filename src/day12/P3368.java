package day12;

import java.io.*;

public class P3368 {
    static int MAXN = 500010;
    static FastIn in = new FastIn();
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] a = new long[MAXN];
//    static long[] tree = new long[MAXN];

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();

        a[0] = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextLong() - a[i-1];
        }

        for (int i = 1; i <= m; i++) {
            int mod = in.nextInt();
            if (mod == 1) {
                int x = in.nextInt();
                int y = in.nextInt();
                int s = in.nextInt();
                update(x, s);
                update(y+1, -s);
            } else {
                int x = in.nextInt();
                out.write(String.valueOf(a[x] + query(x)));
                out.write('\n');
            }
        }
        out.flush();
        out.close();
    }

    public static void update(int index, long x) {
        for (int i = index; i <= MAXN; i += i & -i)
            a[i] += x;
    }

    public static long query(int index) {
        long res = 0;
        for (int i = index; i > 0; i -= i&-i)
            res += a[i];
        return res;
    }
}

class FastIn{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st  = new StreamTokenizer(br);

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }

    public static long nextLong() throws IOException {
        st.nextToken();
        return (long)st.nval;
    }
}
