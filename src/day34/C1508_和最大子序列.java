package day34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 尝试分治算法
 */
public class C1508_和最大子序列 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static int[] a = new int[100010];

    public static void main(String[] args) throws IOException {
        int n = nextInt();

        for (int i = 0; i < n; i++)
            a[i] = nextInt();

        System.out.println(solve(0, n - 1));
    }

    public static long solve(int l, int r) {
        if (l == r) {
            if (a[l] > 0) return a[l];
            else return 0;
        }

        int mid = l + r >> 1;
        long maxLeftSum = solve(l, mid);
        long maxRightSum = solve(mid+1, r);

        long maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = mid; i >= l; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        long maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = mid + 1; i <= r; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }

        return Math.max(Math.max(maxLeftBorderSum, maxRightBorderSum), Math.max(maxLeftSum, maxRightSum));
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
