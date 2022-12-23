package day5;

import java.math.BigInteger;
import java.util.Scanner;

public class P1553 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();


        if (s.contains(".")) {
            String[] split = s.split("\\.");
            System.out.print(reverse(split[0]));
            System.out.print(".");
            System.out.print(reverse(split[1]));
            return;
        }
        if (s.contains("/")) {
            String[] split = s.split("/");
            System.out.print(reverse(split[0]));
            System.out.print("/");
            System.out.print(reverse(split[1]));
            return;
        }
        if (s.contains("%")) {
            String[] split = s.split("%");
            System.out.print(reverse(split[0]));
            System.out.print("%");
            return;
        }

        System.out.println(reverse(s));
        return;
    }

    public static String reverse(String s) {
        BigInteger x = new BigInteger(s);
        BigInteger res = new BigInteger("0");

        // 大于0
        while (true){
            res = res.add(x.mod(new BigInteger("10")));
            x = x.divide(new BigInteger("10"));
            if (x.compareTo(new BigInteger("1")) == -1){
                break;
            }
            res = res.multiply(new BigInteger("10"));
        }
        return String.valueOf(res);
    }
}
