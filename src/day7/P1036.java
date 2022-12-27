package day7;

import java.util.Scanner;

public class P1036 {
    public static int n = 0;
    public static int k = 0;
    public static long res = 0;
    public static int[] a = new int[22];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        dfs(0,0,0);

        System.out.println(res);
    }

    public static void dfs(int m, int sum, int s) {
        // m表示选到第m个数
        // 当前和为sum
        // 、、、（讲地很模糊）、、、、当前枚举中，按照不降原则，s是当前枚举元素的下标
        if (m == k) {
            if (isPrime(sum)) {
                res++;
            }
            return;
        }
        for (int i = s; i < n; i++) {
            dfs(m+1, sum+a[i], i+1);
        }
        return;
    }

    public static boolean isPrime(int a) {

        for (int i = 2; i*i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
