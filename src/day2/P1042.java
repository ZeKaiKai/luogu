package day2;

import java.util.Scanner;

public class P1042 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 存储每局得分
        int W[]= new int[3000];
        int L[] = new int[3000];
        // 局数
        int i = 0;

        while(in.hasNextLine()){
            String s = in.nextLine();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar == 'E'){
                    break;
                }
                if (aChar == 'W'){
                    W[i]++;
                    if (W[i] >= 11 && W[i]-L[i] >= 2){
                        i++;
                    }
                }else if (aChar == 'L'){
                    L[i]++;
                    if (L[i] == 11 && L[i]-W[i] >= 2){
                        i++;
                    }
                }
            }
            /********************************/
        }

        for (int j=0; j<i; j++){
            System.out.print(W[i]);
            System.out.print(":");
            System.out.print(L[i]);
            System.out.println();
        }
    }
}
