package day10;

import java.util.Arrays;
import java.util.Scanner;

class a implements Comparable<a>{
    int s;
    int e;

    public a(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(a o) {
        return this.e - o.e;
    }

    @Override
    public String toString() {
        return "a{" +
                "s=" + s +
                ", e=" + e +
                '}';
    }
}
public class P1803 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        a[] arr = new a[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new a(in.nextInt(), in.nextInt());
        }
        Arrays.sort(arr);

        // 最后一个参加的活动
        a t = new a(0,0);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].s >= t.e) {
                t = arr[i];
                count++;
            }
//            System.out.println(arr[i]);
        }

        System.out.println(count);
    }
}
