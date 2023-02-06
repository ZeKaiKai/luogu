package day19;

import java.io.*;
import java.util.Arrays;

public class lq2059 {
    public static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int[] a = new int[N];
        int[] b = new int[N];

        for (int i = 0; i < N; i++) {
            int x = nextInt();
            a[i] = x;
            b[i] = x;
        }

        Arrays.sort(a);

        int l = a.length;
        int mid = l%2==0 ? a[l>>2] : a[l>>2-1]; // 中位数

        for (int i : b) {
            if (i >= mid) {
                out.print(0);
            } else {
                out.print(mid-i+1);
            }
            out.print(" ");
        }
        out.flush();
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
}
