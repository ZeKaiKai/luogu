package day21;

import java.io.*;

public class P1024 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static double a, b, c, d;

    public static void main(String[] args) throws IOException {
        a = nextDouble();
        b = nextDouble();
        c = nextDouble();
        d = nextDouble();

        for (double i = -100; i <= 100; i++) {
            double l = i;
            double r = i + 1;
            double res_l = func(l);
            double res_r = func(r);

            if (res_l == 0)
                out.printf("%.2f ", l);

            if (res_l * res_r < 0) //异号，开始在大小为1的区间中搜索
            {
                while (r - l > 0.001) {
                    double mid = (l + r) / 2;
                    if (func(mid) * func(r) < 0)
                        l = mid;
                    else
                        r = mid;
                }
                out.printf("%.2f ", l);
            }
        }

        out.flush();
    }

    public static double func(double x) {
        return a * x * x * x + b * x * x + c * x + d;
    }

    public static double nextDouble() throws IOException {
        st.nextToken();
        return st.nval;
    }
}
