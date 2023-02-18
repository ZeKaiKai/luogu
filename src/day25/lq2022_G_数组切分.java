package day25;

import java.io.*;
import java.util.Arrays;

public class lq2022_G_数组切分 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static boolean[] vis;
    public static int[] a;

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        a = new int[N];
        vis = new boolean[N];

        for (int i = 0; i < N; i++) {
            a[i] = nextInt();
        }

        vis[N-1] = true;
        long ans = dfs(0);
        System.out.println(ans);
    }

    public static long dfs(int k) {
        if (k == a.length - 1) {
            if (check()) {
                return 1;
            }
            return 0;
        }
        int res = 0;
        // 切分当前位置
        vis[k] = true;
        res += dfs(k + 1) % 1000000007;

        // 不切分当前位置
        vis[k] = false;
        res += dfs(k + 1) % 1000000007;

        return res;
    }

    // 判断当前切法是否正确
    public static boolean check() {
        int l = 0, r = 0;
        for (int i = 0; i < vis.length; i++) {
            r = i;
            if (vis[i]) {
                if (!checkLianXu(l, r))
                    return false;
                l = r+1;
            }
        }
        return true;
    }

    // 判断当前分组是否连续
    public static boolean checkLianXu(int l, int r) {
        int[] temp = new int[r-l+1];
        System.arraycopy(a, l, temp, 0, r-l+1);
        Arrays.sort(temp);
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] - temp[i-1] != 1) {
                return false;
            }
        }
        return true;
    }

    // 快读
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
