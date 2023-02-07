package day20;

import java.io.*;
import java.util.Arrays;

public class P1102 {
    public static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    public static int[] a;

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int C = nextInt();
        a = new int[N + 1];

        for (int i = 1; i <= N; i++)
            a[i] = nextInt();

        Arrays.sort(a, 1, N + 1);

        long cnt = 0;
        int l = 1;
        int r1 = 0;
        int r2 = 0;
        while (l < N) {
            // 两行核心代码
            // 条件变形为A+C=B，遍历a[l]为A，寻找后面有无对应A+C的值即可（连续区间）
            r1 = bSearch(C+a[l], l, N);
            r2 = bSearch_UpperBound(C+a[l], l, N);
            if (r1!=-1 && r2!=-1)
                cnt += r2-r1+1;
            l++;
        }

        System.out.println(cnt);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    public static int bSearch(int x, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;   //寻找下界时，mid偏向l
            if (a[mid] >= x)
                r = mid;
            else
                l = mid + 1;
        }
        return a[l] == x ? l : -1; //找不到该元素就返回-1
    }

    public static int bSearch_UpperBound(int x, int l, int r) {
        while (l < r) {
            int mid = (l + r + 1) / 2; //寻找上界时，mid偏向r
            if (a[mid] <= x)
                l = mid;
            else
                r = mid - 1;
        }
        return a[l] == x ? l : -1;
    }
}
