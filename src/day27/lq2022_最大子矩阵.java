package day27;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 参考https://blog.csdn.net/m0_57487901/article/details/127094498
 * 细节未理解，暂时不看
 */
public class lq2022_最大子矩阵 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int[][][] max;
    static int[][][] min;
    static int n, m, limit, ans;

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        max = new int[m + 1][n + 1][n + 1];
        min = new int[m + 1][n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                max[j][i][i] = min[j][i][i] = nextInt();
            }
        }
        limit = nextInt();

        // 预处理，得出m列各列的极值
        for (int k = 1; k <= m; k++) {
            // 遍历每行
            for (int i = 1; i <= n; i++) {
                // 计算到某行的最值
                for (int j = i+1; j <= n; j++) {
                    // 表示在第j-1位和第j位取最值
                    max[k][i][j] = Math.max(max[k][i][j - 1], max[k][j][j]);
                    min[k][i][j] = Math.min(min[k][i][j - 1], min[k][j][j]);
                }
            }
        }

        for (int x1 = 1; x1 <= n; x1++) {
            for (int x2 = x1; x2 <= n; x2++) {
                int l = 1, r = m;
                while (l < r) {
                    int mid = l + r + 1 >> 1;  //求最大值
                    if (check(x1, x2, mid))
                        l = mid;
                    else
                        r = mid - 1;
                }
                if (check(x1, x2, r)) ans = Math.max(ans, (x2 - x1 + 1) * r);
            }
        }
        out.println(ans);
        out.flush();
    }

    public static boolean check(int x1, int x2, int x) {
        Deque<Integer> qmax = new ArrayDeque<>();
        Deque<Integer> qmin = new ArrayDeque<>();

        for (int i = 1; i <= m; i++) {
            // 处理最小
            if (!qmin.isEmpty() && qmin.peekFirst() < i-x+1) qmin.pollFirst();
            while(!qmin.isEmpty() && min[qmin.peekLast()][x1][x2] > min[i][x1][x2]) qmin.pollLast();
            qmin.offerLast(i);

            // 处理最大
            if (!qmax.isEmpty() && qmax.peekFirst() < i-x+1) qmax.pollFirst();
            while (!qmax.isEmpty() && max[qmax.peekLast()][x1][x2] < max[i][x1][x2]) qmax.pollLast();
            qmax.offerLast(i);

            //
            if (i >= x && max[qmax.peekFirst()][x1][x2] - min[qmin.peekFirst()][x1][x2] <= limit)
                return true;
        }
        return false;
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    //max[k][i][j]表示第k列中[i,j]之间的最大值
//    static int[][][] max;
//    static int[][][] min;
//    static int n, m, limit,ans;
//    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
//    public static void main(String[] args) throws IOException {
//        String[] s=br.readLine().split(" ");
//        n = Integer.parseInt(s[0]);
//        m = Integer.parseInt(s[1]);
//        max=new int[m+1][n+1][n+1];
//        min=new int[m+1][n+1][n+1];
//        for (int i = 1; i <= n; i++) {
//            s=br.readLine().split(" ");
//            for (int j = 1; j <= m; j++) {
//                max[j][i][i] = min[j][i][i] = Integer.parseInt(s[j-1]);
//            }
//        }
//        limit = Integer.parseInt(br.readLine());
//        //预处理  复杂度 n^2*m
//        for (int k = 1; k <= m; ++k) {
//            for (int i = 1; i <= n; ++i) {
//                for (int j = i + 1; j <= n; ++j) {
//                    max[k][i][j] = Math.max(max[k][i][j - 1], max[k][j][j]);
//                    min[k][i][j] = Math.min(min[k][i][j - 1], min[k][j][j]);
//                }
//            }
//        }
//        for (int x1 = 1; x1 <= n; x1++) {
//            for (int x2 = x1; x2 <= n; x2++) {
//                int l = 1, r = m;
//                while (l < r) {
//                    int mid = l + r + 1 >> 1;
//                    if (check(x1, x2, mid)) l = mid;
//                    else r = mid - 1;
//                }
//                if (check(x1,x2,r)) ans=Math.max(ans,(x2-x1+1)*r);
//            }
//        }
//        out.println(ans);
//        out.flush();
//    }
//
//    //k是窗口大小
//    static boolean check(int x1, int x2, int k) {
//        Deque<Integer> qmax = new ArrayDeque<>();
//        Deque<Integer> qmin = new ArrayDeque<>();
//        for (int i = 1; i <= m; i++) {
//            //处理最小
//            if (!qmin.isEmpty() && qmin.peekFirst() < i - k + 1) qmin.pollFirst();
//            while (!qmin.isEmpty() && min[qmin.peekLast()][x1][x2] > min[i][x1][x2]) qmin.pollLast();
//            qmin.offerLast(i);
//            //处理最大
//            if (!qmax.isEmpty() && qmax.peekFirst() < i - k + 1) qmax.pollFirst();
//            while (!qmax.isEmpty() && max[qmax.peekLast()][x1][x2] < max[i][x1][x2]) qmax.pollLast();
//            qmax.offerLast(i);
//            //说明窗口为k
//            if (i >= k && max[qmax.peekFirst()][x1][x2] - min[qmin.peekFirst()][x1][x2] <= limit) return true;
//        }
//        return false;
//    }
}
