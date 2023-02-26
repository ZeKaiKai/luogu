package day31_模拟比赛;

import java.util.Scanner;

public class lq2019_1_组队 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] a = new int[20][5];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int maxSum = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 20; k++) {
                    for (int l = 0; l < 20; l++) {
                        for (int m = 0; m < 20; m++) {
                            if (i!=j && i!=k && i!=l && i!=m && j!=k && j!=l && j!=m && k!=l && k!=m && l!=m) {
                                int sum = a[i][0] + a[j][1] + a[k][2] + a[l][3] + a[m][4];
                                maxSum = Math.max(sum, maxSum);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(maxSum);
//        System.out.println (490);
    }
}