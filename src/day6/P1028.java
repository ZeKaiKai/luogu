package day6;

import java.util.Scanner;

public class P1028 {
    public static int[] result = new int[2000];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // dfs
//        System.out.println(dfs(n));
        // 递推
        System.out.println(solve(n));
    }

    public static int dfs(int n) {
        if (n == 1) {
            return 1;
        } else {
            if (result[n] != 0){
                return result[n];
            }
            int res = 0;
            for (int i = 1; i <= n / 2; i++) {
                res += dfs(i);
            }
            // 每个分支都算一个结果
            result[n] = res+1;
            return res + 1;
        }
    }

    // 递推
    // f1 = 1
    // f2 = f1 +1 = 2
    // f3 = f1 + 1 = 2
    // f4 = f1 + f2 +1 = 4
    // f5 = f1 + f2 +1 = 4
    // f6 = f1 + f2 + f3 + 1 = 6
    public static int solve(int n){
        int[] res = new int[1005];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                res[i] += res[j];
            }
            res[i] += 1;
        }
        return res[n];
    }
}
