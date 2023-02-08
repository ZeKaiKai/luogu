package day22;

import java.io.*;
import java.util.Arrays;

public class P2440 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int[] a;
    public static int K;
    public static int N;

    public static void main(String[] args) throws IOException {
        N = nextInt();
        K = nextInt();
        a = new int[N + 1];
        int max = 0;
        for (int i = 1; i <= N; i++){
            a[i] = nextInt();
            max = a[i]>max ? a[i] : max;
        }

        int l = 0, r = max;
        while (l+1 < r) {
            int mid = (l + r) >> 1;

//            if (r - l == 1)
//                if (check(r))
//                    l = r;
//                else
//                    r = l;

            if (check(mid))
                l = mid;
            else
                r = mid;
        }

        out.println(l);
        out.flush();
    }

    // 判断该长度是否可以切分出k段木材
    public static boolean check(int x) {
        int cnt = 0;
        for (int i : a) {
            while (i >= x) {
                cnt++;
                i-=x;
            }
        }
        return cnt>=K;
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
