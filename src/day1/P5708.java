package day1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P5708 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float a = in.nextFloat();
        float b = in.nextFloat();
        float c = in.nextFloat();

        DecimalFormat df = new DecimalFormat("0.0");

        float p = (a+b+c)/2;
        double res = Math.sqrt((double)p*(p-a)*(p-b)*(p-c));

        System.out.println(df.format(res));
    }
}
