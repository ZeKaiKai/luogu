package day1;

import java.util.Scanner;

public class B2005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String next = in.next();

        for (int i = 1; i <= 3; i++){
            for (int j = 1; j <= 3-i; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++){
                System.out.print(next);
            }
            System.out.println();
        }
    }
}
