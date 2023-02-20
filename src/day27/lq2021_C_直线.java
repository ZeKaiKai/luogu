package day27;

import java.util.HashSet;

public class lq2021_C_直线 {
    static class a {
        double k;
        double b;

        public a(double k, double b) {
            this.k = k;
            this.b = b;
        }
    }

    public static HashSet<a> set = new HashSet<>();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = i+1; k < 20; k++) {
                    for (int l = j+1; l < 21; l++) {
                        double kkk =  (k-i)*1.0 / (l-j)*1.0;
                        double b = j*1.0 - kkk*i;
                        a a = new a(kkk, b);
                        set.add(a);
                    }
                }
            }
        }
        System.out.println(set.size());
    }

}
