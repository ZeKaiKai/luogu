package day20;

import java.io.*;
import java.util.Arrays;

public class P1102 {
    public static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        long C = nextLong();
        long[] a = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            a[i] = nextLong();
        }

        Arrays.sort(a, 1, N + 1);

        int i = bSearch(4, a, 1, N); //分界线

        int cnt = 0;

        /////////////////////////////////////////////////

    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    public static long nextLong() throws IOException {
        st.nextToken();
        return (long) st.nval;
    }

    public static int bSearch(int x, long[] a, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid] >= x)
                r = mid;
            else
                l = mid + 1;
        }
        return a[l] == x ? l : -1; //找不到该元素就返回-1
    }
}
