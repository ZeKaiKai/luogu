package day27;

import java.util.ArrayList;
import java.util.HashSet;

public class lq2021_C_直线 {
    // 表示点的类
    static class a {
        int x;
        int y;

        public a(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 结果集
    public static HashSet<String> ans = new HashSet<>();

    public static void main(String[] args) {
        // 点集
        HashSet<a> point = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 21; j++) {
                a a = new a(i, j);
                point.add(a);
            }
        }
        // 点集转数组
        ArrayList<a> arr = new ArrayList<>(point);
        int len = arr.size();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                cnt(arr.get(i), arr.get(j));
            }
        }

        System.out.println(ans.size());

        System.out.println(40257);
    }

    public static void cnt(a a, a b) {
        int x1 = a.x, y1 = a.y;
        int x2 = b.x, y2 = b.y;

        // 斜率不存在的情况
        if (x2-x1 == 0){
            ans.add("x="+x1);
            return;
        }

        // 计算k的最简式
        int up = y2 - y1, down = x2 - x1;
        int div = gcd(up, down);
        String K = (up/div) + "/" + (down/div);
        // 计算b的最简式
        // 由y=kx+b，k=(y2-y1)/(x2-x1)，
        // b = y1 - [(y2-y1)*x1] / (x2-x1)
        // b = [(x2-x1)*y1]/(x2-x1) - [(y2-y1)*x1] / (x2-x1)
        int up_b = (x2-x1)*y1 - (y2-y1)*x1;
        int down_b = x2-x1;
        int div_b = gcd(up_b, down_b);
        String B = (up_b/div_b) + "/" + (down_b/div_b);
        // 加入ans中去重计数
        ans.add(K + "x+" + B);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
