package day1;

import java.util.Scanner;

public class P5704 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        char c = s.toCharArray()[0];
        c = (char)((int)c - 32);

        System.out.println(c);
    }
}
