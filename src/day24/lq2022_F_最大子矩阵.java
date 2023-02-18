package day24;

import java.io.*;

public class lq2022_F_最大子矩阵 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int[][] m;
    public static int limit = 0;

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int M = nextInt();
        m = new int[N][M];

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                m[i][j] = nextInt();
                max = Math.max(m[i][j], max);
                min = Math.min(m[i][j], min);
            }
        }

        limit = nextInt();
        // 判断最大的情况，正确则直接输出，结束程序
        if (max - min <= limit) {
            System.out.println(M * N);
            return;
        }
        
        // 尝试二分答案
        // 二分行数
        int l_N = 1, r_N = N;
        int l_M = 1, r_M = M;
        while (l_N < r_N) {
            int mid_N = (l_N + r_N + 1) >> 1;
            // 二分列数
            l_M = 1;
            r_M = M;
            while (l_M < r_M) {
                int mid_M = (l_M + r_M + 1) >> 1;
                // 符合题意，则该矩阵可能更大，也可能等于
                if (check(mid_N, mid_M)) {
                    l_M = mid_M;
                } else {
                    r_M = mid_M - 1;
                }
            }
            // 符合题意，缩小范围
            if (check(mid_N, l_M)) {
                l_N = mid_N;
            } else {
                r_N = mid_N - 1;
            }
        }
        System.out.println(l_N * l_M);
    }

    /**
     * 滑动窗口法判断是否存在该规模的矩阵符合题意
     * @param N 行数
     * @param M 列数
     * @return
     */
    public static boolean check(int N, int M) {
        int x_limit = m.length;    //行数
        int y_limit = m[0].length; //列数

        for (int start_x = 0; start_x <= x_limit - N; start_x++) {
            for (int start_y = 0; start_y <= y_limit - M; start_y++) {
                if (isTrue(start_x, start_y, N, M))
                    return true;
            }
        }
        return false;
    }

    /**
     * 判断该矩阵是否符合题意
     *
     * @param start_x 初始横坐标
     * @param start_y 初始纵坐标
     * @param N       行数
     * @param M       列数
     * @return
     */
    public static boolean isTrue(int start_x, int start_y, int N, int M) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = start_x; i < start_x + N; i++) {
            for (int j = start_y; j < start_y + M; j++) {
                max = Math.max(m[i][j], max);
                min = Math.min(m[i][j], min);
            }
        }
        return max-min <= limit;
    }

    // 快读
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
