package day3;

import java.util.Arrays;
import java.util.Scanner;

public class P5717 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[3];

        arr[0] = in.nextInt();
        arr[1] = in.nextInt();
        arr[2] = in.nextInt();

        Arrays.sort(arr);

        int a = arr[0] * arr[0];
        int b = arr[1] * arr[1];
        int c = arr[2] * arr[2];

        if (arr[0] + arr[1] <= arr[2]) {
            System.out.println("Not triangle");
        } else {
            if (a + b == c) {
                System.out.println("Right triangle");
            } else if (a + b > c) {
                System.out.println("Acute triangle");
            } else if (a + b < c) {
                System.out.println("Obtuse triangle");
            }
            if (arr[0] == arr[1]) {
                System.out.println("Isosceles triangle");
            }
            if ((arr[0] == arr[1]) && (arr[1] == arr[2])){
                System.out.println("Equilateral triangle");
            }
        }
    }
}
