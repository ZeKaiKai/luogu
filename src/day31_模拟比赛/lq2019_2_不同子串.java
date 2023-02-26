package day31_模拟比赛;

import java.util.HashSet;

public class lq2019_2_不同子串 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String ss = "0100110001010001";
        char[] s = ss.toCharArray();

        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j < s.length - i; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = j; k <i; k++) {
                    sb.append(s[k]);
                }
                if (sb.length() > 0)
                    set.add(sb.toString());
            }
        }

        System.out.println(set.size());

        System.out.println(54);
    }
}
