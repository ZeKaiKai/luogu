package day10;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1090 {
    static PriorityQueue<Integer> l = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            l.add(in.nextInt());
        }

        long sum = 0;
        Integer head = 0;
        Integer next = 0;
        for (int i = 0; i < n-1; i++) {
            head = l.poll();
            next = l.poll();
            l.add(head + next);
            sum += head + next;
        }

        System.out.println(sum);
    }
}
