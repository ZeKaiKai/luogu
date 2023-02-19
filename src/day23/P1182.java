package day23;

import java.io.*;

public class P1182 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static int N;
    public static int M;
    public static int[] a = new int[100005];

    public static void main(String[] args) throws IOException {
        N = nextInt();
        M = nextInt();
        int l = 0, r = 0;
        for (int i = 0; i < N; i++) {
            a[i] = nextInt();
            l = Math.max(a[i], l);
            r += a[i];
        }

        // 二分答案
        while (l < r) {
            int mid = (l + r) >> 1;
            int f = check(mid);
            if (f == 0) {
                r = mid;       //若分段数等于指定数M，说明该答案可行，但还有可能存在更优解，所以r=mid
            } else if (f == 1) {
                l = mid + 1;   //若分段数大于指定数M，则x值过小，所以l=mid+1
            } else if (f == -1) {
                r = mid - 1;   //若分段数小于指定数M，说明x值太大，所以r=mid-1
            }
        }

        System.out.println(l);
    }

    /**
     * check函数
     * 若分段数大于指定数M，则x值过小，所以l=mid+1
     * 若分段数等于指定数M，说明该答案可行，但还有可能存在更优解，所以r=mid
     * 若分段数小于指定数M，说明x值太大，所以r=mid-1
     *
     * @param x
     * @return
     */
    public static int check(int x) {
        int cur = 0, cnt = 0;
        for (int i = 0; i < N; i++) {
            if (cur + a[i] > x) {
                cur = 0;
                cnt++;
            }
            cur += a[i];
        }
        cnt++; //算上最后一个分段
        if (cnt == M)
            return 0;
        else if (cnt > M)
            return 1;
        else
            return -1;
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
