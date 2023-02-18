package day26;

import java.io.*;
import java.util.LinkedList;


public class P1440 {
    static class node {
        int order;
        int value;

        public node(int order, int value) {
            this.order = order;
            this.value = value;
        }
    }

    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static LinkedList<node> min = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                out.println(0);
            } else {
                out.println(min.peekFirst().value);
            }

            int t = nextInt();
            if (!min.isEmpty() && i - min.peekFirst().order >= m) min.pollFirst();
            while (!min.isEmpty() && min.peekLast().value > t) min.pollLast();

            node temp = new node(i, t);
            min.add(temp);
        }
        out.flush();
    }

    // 快读
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
