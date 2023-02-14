package day23;

import java.io.*;
import java.util.Scanner;

public class P3612 {
//    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        long i = in.nextLong();

        long len = s.length();
        long l = len, r = len;

        while (i > len) {
            l = len;
            r = len;
            while (r < i)
                r *= 2;
            l = r / 2;

            if (i == l + 1) {
                i = l;
                r = l;
                l = r / 2;
            } else if (i > l + 1) {
                i = i - l - 1;
                r = l;
                l = r / 2;
            }

            if (i == 0)
                i = l;
        }
        out.println(s.charAt((int)(i-1)));
        out.flush();
    }

//    public static String nextString() throws IOException {
//        st.nextToken();
//        return st.sval;
//    }
//
//    public static long nextLong() throws IOException {
//        st.nextToken();
//        return (long) st.nval;
//    }
}
