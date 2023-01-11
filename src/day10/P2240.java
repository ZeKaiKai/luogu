package day10;

import java.util.Arrays;
import java.util.Scanner;

class gold implements Comparable<gold>{
    int m;
    int v;
    int xjb; // 性价比

    public gold(int m, int v) {
        this.m = m;
        this.v = v;
        this.xjb = (int)(100000*((v*1.0)/(m*1.0)));
    }

    @Override
    public int compareTo(gold o) {
        return (int) (o.xjb - this.xjb);
    }

    @Override
    public String toString() {
        return "gold{" +
                "m=" + m +
                ", v=" + v +
                ", xjb=" + xjb +
                '}';
    }
}

public class P2240 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int v = in.nextInt();
        gold[] golds = new gold[n];
        for (int i = 0; i < n; i++) {
            golds[i] = new gold(in.nextInt(), in.nextInt());
        }
        in.close();
        Arrays.sort(golds);

        int i = 0;
        double sum = 0.0;
        while(v>0 && i<n){
            if (v >= golds[i].m){
                v -= golds[i].m;
                sum += golds[i].v;
            } else {
                sum += (golds[i].xjb*1.0)/100000 * v;
                v = 0;
            }
            i++;
        }

        System.out.printf("%.2f", sum);
    }
}
