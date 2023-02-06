package day20;

import java.io.*;

public class P2249 {
    public static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int[] a;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        N = nextInt();
        M = nextInt();
        a = new int[N];

        for (int i = 0; i < N; i++)
            a[i] = nextInt();

        for (int i = 0; i < M; i++) {
            int q = nextInt();
            int res = find(q, 0,N-1); //二分查找区间（下标0~N-1）
            out.print(res + 1);
            out.print(" ");
        }
        out.flush();
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    public static int find(int x, int l, int r) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (a[mid] >= x)
                r = mid;
            else
                l = mid+1;
        }

        return a[l]==x ? l:-2;
    }
}
