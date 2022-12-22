package day4;

import java.util.Arrays;
import java.util.Scanner;

public class P1125 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();

        int[] count = new int[27];

        int[] prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};

        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        int max=count[1];
        int min=0;
        // min不能初始化为0，初始化为第一个非0的数字
        for (int i : count) {
            if (i > 0){
                min = i;
            }
        }

        for (int i=2; i < count.length; i++) {
            if (count[i] > 0){
                if (max < count[i]){
                    max = count[i];
                }
                if (min > count[i]){
                    min = count[i];
                }
            }
        }
        int i = Arrays.binarySearch(prime, max - min);
        if (i>=0){
            System.out.println("Lucky Word");
            System.out.println(prime[i]);
        } else {
            System.out.println("No Answer");
            System.out.println(0);
        }
    }
}
