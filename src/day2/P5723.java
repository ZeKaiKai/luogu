package day2;

import java.util.Scanner;

public class P5723 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();

        Boolean[] isPrime = new Boolean[L+1];

        for (int i = 1; i <= L; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= L; i++){
            if (isPrime[i]){
                for (int j = 2*i; j<=L; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        int sum = 0;
        int count = 0;
        for (int i=2; i<=L; i++){
            if (isPrime[i]){
                sum += i;
                count += 1;
                if (sum > L){
                    sum -= i;
                    count -=1;
                    break;
                }
                System.out.println(i);
            }
        }
        System.out.println(count);

    }
}
