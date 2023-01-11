package day10;

import java.util.Arrays;
import java.util.Scanner;

class couple implements Comparable<couple>{
    int index;
    int t;

    public couple(int index, int t) {
        this.index = index;
        this.t = t;
    }

    @Override
    public String toString() {
        return "couple{" +
                "index=" + index +
                ", t=" + t +
                '}';
    }

    @Override
    public int compareTo(couple o) {
        return this.t - o.t;
    }
}

public class P1223 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        couple[] arr = new couple[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new couple(i+1, in.nextInt());
        }
        Arrays.sort(arr);

        int temp = 0;
        couple[] wait_times = new couple[n];

        for (int i = 0; i < n; i++) {
            wait_times[i] = new couple(arr[i].index, arr[i].t);

            wait_times[i].t = temp;
            temp += arr[i].t;
        }

        double total_time = 0;
        for (int i = 0; i < n; i++) {
            total_time += wait_times[i].t;
        }

        for (couple couple : arr) {
            System.out.print(couple.index + " ");
        }
        System.out.println();

        System.out.printf("%.2f", total_time / n);
    }
}
