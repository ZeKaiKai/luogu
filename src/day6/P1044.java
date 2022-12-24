package day6;

import java.math.BigInteger;
import java.util.Scanner;

public class P1044 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        BigInteger res = new BigInteger("1");
        BigInteger ONE = BigInteger.valueOf(1);
        BigInteger TWO = BigInteger.valueOf(2);
        BigInteger FOUR = BigInteger.valueOf(4);

        for (int i = 2; i <= n; i++) {
            BigInteger nn = BigInteger.valueOf(i);
            res = res.multiply(FOUR.multiply(nn).subtract(TWO));
            res = res.divide(nn.add(ONE));
        }

        System.out.println(res);
    }
}
