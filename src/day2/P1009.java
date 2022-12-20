package day2;

import java.math.BigInteger;
import java.util.Scanner;

public class P1009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        BigInteger sum = new BigInteger("1");

        for (int i=2; i<=n; i++){
            // 计算i!
            BigInteger bigInteger = new BigInteger("1");
            for (int j=2; j<=i; j++){
                bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(j)));
            }
            sum = sum.add(bigInteger);
        }

        System.out.println(sum);
    }
}
