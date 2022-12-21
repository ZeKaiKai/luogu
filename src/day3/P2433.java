package day3;

import java.util.Scanner;

public class P2433 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int t = in.nextInt();
        int s = in.nextInt();

        if (t==0){
            System.out.println(0);
        }else{
            float f = (float) s/(float) t;
            int ff = f%1==0 ? (int)f : (int)f+1;
            System.out.println((m-ff)<0 ? 0 : (m-ff));
        }
    }
}
