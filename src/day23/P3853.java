package day23;

import java.io.*;

public class P3853 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int[] a;
    public static int L;
    public static int N;
    public static int K;

    public static void main(String[] args) throws IOException {
        L = nextInt();
        N = nextInt();
        K = nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = nextInt();
        }

        int l = 1, r = L, ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (judge(mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        out.println(ans);
        out.flush();
    }

    public static boolean judge(int x) {
//        int cnt = 0; //已经放置的路标数量
//        int cur = 0; //当前位置（距离）
//
//        for (int i = 1; i < N; i++) {
//            if (cnt > K)
//                break;
//            if (a[i] - cur <= x) {
//                cur += a[i]; //当前路标符合条件
//            } else {
//                cur += x; //放置路标在距离x处（即尽量远）
//                i--;      //为保证下次循环时，模拟从新放的路标开始考虑
//                cnt++;    //放置路标数增加
//            }
//        }
//
//        return cnt <= K;
        int sum = 0;
        for (int i = 1; i < N; i++) {
            if (a[i] - a[i-1] >= x) {
                // 直接计算可以放多少个
                if ((a[i] - a[i-1]) % x == 0)
                    sum += (a[i]-a[i-1])/x - 1; //恰好可以放下
                else
                    sum += (a[i]-a[i-1])/x;  //不足以放下，除法向上转型去除多余的
            }
        }
        return sum <= K;
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
