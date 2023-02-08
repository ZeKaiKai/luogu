package day22;

import java.io.*;
import java.util.Arrays;

public class P1678 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int[] a;

    public static void main(String[] args) throws IOException {
        int M = nextInt();
        int N = nextInt();
        a = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            a[i] = nextInt();
        }

        Arrays.sort(a, 1, M+1);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int x = nextInt();
            int index = bSearch_lower(x, 1, M); //第一个大于等于x的下标
            if (a[index] == x) //录取分等于估分，不满意度为0，跳过
                continue;
            int lower = Integer.MAX_VALUE;
            int upper = Integer.MAX_VALUE;
            if (index == 1) {
                // 估分小于等于全部录取分，取最小录取分
                upper = a[index];
            } else {
                //找到第一个小于x的
                lower = a[index-1];
                //第一个大于x的
                upper = a[index];
            }
            sum += Math.min(Math.abs(x-lower), Math.abs(x-upper));
//            sum += Math.abs(x - Math.min(x-lower, x-upper));
        }
        out.println(sum);
        out.flush();
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    public static int bSearch_lower(int x, int l, int r) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (a[mid] >= x)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
