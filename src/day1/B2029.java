package day1;

import java.util.Scanner;

public class B2029 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int r = in.nextInt();
        double v = Math.PI*r*r*h;

        int n = (int)((20/(v/1000))%1==0 ? (20/(v/1000)):(20/(v/1000))+1); // 不是整数就+1

        System.out.println(n);
    }
}
