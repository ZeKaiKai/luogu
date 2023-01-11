package day10;

import java.util.Arrays;
import java.util.Scanner;

class data implements Comparable<data>{
    int x;
    int y;

    public data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(data o) {
        return this.y - o.y;
    }

    @Override
    public String toString() {
        return "data{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class P1478 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        data[] data = new data[n];

        for (int i = 0; i < n; i++) {
            data[i] = new data(in.nextInt(), in.nextInt());
        }

        Arrays.sort(data);

        int count = 0;
        for (data d : data) {
            if (d.x <= a+b && s-d.y >= 0) {
                count++;
                s -= d.y;
            }
        }

        System.out.println(count);
    }
}
