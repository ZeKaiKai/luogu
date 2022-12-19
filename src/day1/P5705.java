package day1;

import java.util.Scanner;

public class P5705 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String next = in.next();
        char[] array = next.toCharArray();

        for (int i=array.length-1; i >= 0; i--){
            System.out.print(array[i]);
        }
    }
}
