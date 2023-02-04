package day15;

import java.util.Scanner;

public class P4913 {
    public static int[][] a;
    public static int res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        a = new int[n+1][2];

        for (int i = 1; i <= n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }

        search(1, 1);
        System.out.println(res);
    }
    public static void search(int i, int depth){
        if (i == 0)
            return;
        search(a[i][0], depth+1);
        search(a[i][1], depth+1);
        // 统计深度最大值
        res = depth > res ? depth : res;
    }
}
