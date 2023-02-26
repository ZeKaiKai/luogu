package day31_模拟比赛;

import java.util.HashSet;

public class lq2019_4_数的分解 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        int n = 2019;

        for (int i = 1; i < 2019; i++) {
            if (!check(i))
                continue;
            for (int j = 1; j < 2019; j++) {
                int k = n - i - j;
                if (check(j) && check(k) && k > 0 && i != j && j != k && i != k) {
                    set.add(i + "+" + j + "+" + k);
                    set.add(i + "+" + k + "+" + j);
                    set.add(j + "+" + i + "+" + k);
                    set.add(j + "+" + k + "+" + i);
                    set.add(k + "+" + i + "+" + j);
                    set.add(k + "+" + j + "+" + i);
                }
            }
        }

        System.out.println(set.size() / 6.0);

        System.out.println(40785);

    }

    public static boolean check(int x) {
        String s = String.valueOf(x);
        for (char c : s.toCharArray()) {
            if (c == '2' || c == '4')
                return false;
        }
        return true;
    }
}
