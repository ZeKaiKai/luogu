package day28;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class lq2021_D_货物摆放 {
    public static void main(String[] args) {
        long n = 2021041820210418l;
        long end = (long) Math.sqrt(n);
        HashSet<Long> set = new HashSet<>();

        for (long i = 1; i <= end+1; i++) {
            if (n % i == 0) {
                set.add(n/i);
                set.add(i);
            }
        }

        int cnt = 0;
        for (long a : set) {
            for (long b : set) {
                for (long c : set) {
                    if (a*b*c == n)
                        cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
