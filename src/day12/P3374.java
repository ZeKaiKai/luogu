//package day12;
//
//import java.io.*;
//
//public class P3374 {
//    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//    public static FastIn in = new FastIn();
//    static int MAXN = 500010;
//    static int[] tree = new int[MAXN];
//
//    public static void main(String[] args) throws IOException {
//        int n = in.nextInt();
//        int m = in.nextInt();
//
//        for (int i = 1; i <= n; i++) {
//            update(i, in.nextInt());
//        }
//
//        for (int i = 1; i <= m; i++) {
//            if (in.nextInt() == 1) {
//                update(in.nextInt(), in.nextInt());
//            } else {
//                out.write(String.valueOf(query(in.nextInt(), in.nextInt())));
//                out.write('\n');
//            }
//        }
//        out.flush();
//        out.close();
//    }
//
//    public static void update(int i, int x) {
//        for (int pos = i; pos < MAXN; pos += pos & (-pos))
//            tree[pos] += x;
//    }
//
//    public static int query(int n) {
//        int ans = 0;
//        for (int pos = n; pos > 0; pos -= pos & (-pos)) {
//            ans += tree[pos];
//        }
//        return ans;
//    }
//
//    public static int query(int a, int b) {
//        return query(b) - query(a - 1);
//    }
//}
//
//class FastIn {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StreamTokenizer st = new StreamTokenizer(br);
//
//    public static String nextLine() throws IOException {
//        return br.readLine();
//    }
//
//    public static int nextInt() throws IOException {
//        st.nextToken();
//        return (int) st.nval;
//    }
//
//    public static String nextString() throws IOException {
//        st.nextToken();
//        return st.sval;
//    }
//
//    public static long nextLong() throws IOException {
//        st.nextToken();
//        return (long) st.nval;
//    }
//}