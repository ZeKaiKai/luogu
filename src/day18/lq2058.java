package day18;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

class a implements Comparable<a>{
    char key;
    int cnt;

    a(char k, int c) {
        key = k;
        cnt = c;
    }

    @Override
    public int compareTo(a o) {
        return o.cnt - this.cnt;
    }
}

public class lq2058 {
    public static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static a[] a = new a[26];

    public static void main(String[] args) throws IOException {
        String s = nextString();

        for (int i = 0; i < 26; i++)
            a[i] = new a((char) ('A' + i), 0);

        for (char c : s.toCharArray()) {
            a[c-'A'].cnt++;
        }

        Arrays.sort(a);

        for (int i = 0; i < 26; i++) {
            out.print(a[i].key);
            if (i==25 || a[i].cnt > a[i+1].cnt)
                break;
        }

        out.flush();
    }

    public static String nextString() throws IOException {
        st.nextToken();
        return st.sval;
    }
}
