package day22;

import java.io.*;

public class P2678 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int[] a;
    public static int M;
    public static int L;
    public static int N;

    public static void main(String[] args) throws IOException {
        L = nextInt();
        N = nextInt();
        M = nextInt();
        a = new int[N+2];
        // a[0]看作到起点的距离，值为0
        for (int i = 1; i <= N; i++)
            a[i] = nextInt(); //两块之间的距离
        a[N+1] = L;  //最后一块到终点距离

        int l = 1, r = L, ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (judge(mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        out.println(ans);
        out.flush();
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    // 关键，判断当前解是否可行
    public static boolean judge(int x) {
        int cnt = 0;
        int now = 0; //参赛者当前位置，0为起点
        for (int i = 1; i < a.length; i++){
            if (a[i] - a[now] < x)
                cnt++;//移走当前石头
            else
                now=i;//大于当前解，则跳过去，考虑解下来的石头
        }

        return cnt <= M;
    }
}
