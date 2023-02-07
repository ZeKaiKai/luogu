package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1873 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        long M = nextLong();
        long[] a = new long[N+1];
        long max = 0;

        for (int i = 1; i <= N; i++) {
            a[i] = nextLong();
            max = Math.max(max, a[i]);
        }
        
        long l = 1, r = max;
        while (l < r) {
            long mid = (l+r+1) / 2;
            long sum = 0;

            for (int i = 1; i <= N; i++)
                if (a[i] > mid)
                    sum += a[i] - mid;

            if (sum >= M)
                l = mid;
            else
                r = mid-1;
        }

        System.out.println(r);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    public static long nextLong() throws IOException {
        st.nextToken();
        return (long) st.nval;
    }
}