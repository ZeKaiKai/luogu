package day26;

import java.io.*;
import java.util.LinkedList;

public class P2032 {
    static class node{
        int order, value;
        node(int order, int value) {
            this.order = order;
            this.value = value;
        }
    }
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static LinkedList<node> max = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int k = nextInt();

        for (int i = 0; i < n; i++) {
            int t = nextInt();
            if (!max.isEmpty() && i - max.peekFirst().order >= k) max.pollFirst();
            while(!max.isEmpty() && max.peekLast().value < t) max.pollLast();

            node temp = new node(i, t);
            max.add(temp);

            if (i >= k-1) {
                out.println(max.peekFirst().value);
            }
        }

        out.flush();
    }

    public static int nextInt() throws IOException{
        st.nextToken();
        return (int) st.nval;
    }
}
