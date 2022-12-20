package day2;

import java.util.Scanner;

public class P1980 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int x = in.nextInt();

        int count = 0;
        for (int i=1; i<=n; i++){
            int d = i;
            while(d > 0){
                if(d%10 == x){
                    count++;
                }
                d /=10;
            }
        }

        System.out.println(count);
    }
}
