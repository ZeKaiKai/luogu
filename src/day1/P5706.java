package day1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P5706 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float t = in.nextFloat();
        int n = in.nextInt();
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println(df.format(t / n));
        System.out.println(2 * n);
    }
}
