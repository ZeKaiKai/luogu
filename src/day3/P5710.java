package day3;

import java.util.Scanner;

public class P5710 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        boolean a = x % 2 == 0;
        boolean b = x > 4 && x <= 12;

        if (a && b) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }

        System.out.print(" ");

        if (a || b) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }

        System.out.print(" ");

        if ((a && !b) || (!a && b)){
            System.out.print(1);
        }else{
            System.out.print(0);
        }

        System.out.print(" ");

        if (!a && !b){
            System.out.print(1);
        }else{
            System.out.print(0);
        }
    }
}
