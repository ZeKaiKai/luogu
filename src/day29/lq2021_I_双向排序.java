package day29;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class lq2021_I_双向排序 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        Integer[] a = new Integer[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int f = nextInt();
            int index = nextInt();

            // 1-i降序
            if (f==0)
                Arrays.sort(a, 1, index+1, Comparator.reverseOrder());
//                Arrays.sort(a, 1, index+1, (o1,o2) -> o2.compareTo(o1));
            else
                Arrays.sort(a, index, n+1);
        }

        for (int i = 1; i <= n; i++)
            out.print(a[i] + " ");

        out.flush();
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
