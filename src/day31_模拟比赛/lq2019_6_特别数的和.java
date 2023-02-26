package day31_模拟比赛;

import java.util.Scanner;

public class lq2019_6_特别数的和 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i))
                sum += i;
        }

        System.out.println(sum);
    }

    public static boolean check(int x) {
        String s = String.valueOf(x);
        for (char c : s.toCharArray())
            if (c=='2' || c=='0' || c=='1' || c=='9')
                return true;

        return false;
    }
}
