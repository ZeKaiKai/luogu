package day2;

import java.util.Arrays;
import java.util.Scanner;

public class P5726 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        double sum = 0;
        for (int i=1; i<n-1; i++){
            sum += arr[i];
        }
        double res = sum / (n-2);

        System.out.printf("%.2f", res);
    }
}
