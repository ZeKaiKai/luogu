package day14;

import java.util.HashSet;
import java.util.Scanner;

public class P3370 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(in.next());
        }
        System.out.println(set.size());
    }
}
