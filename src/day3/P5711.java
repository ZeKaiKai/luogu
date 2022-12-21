package day3;

import java.util.Scanner;

public class P5711 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        // 基础闰年判断
        if ((n%4==0 && n%100!=0) || n%400==0){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
