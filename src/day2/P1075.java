package day2;

import java.util.Scanner;

public class P1075 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

//        if (n == 1){
//            System.out.println(n);
//            return;
//        }
//
//        Boolean[] isPrime = new Boolean[n+1];
//
//        for (int i=1; i<=n; i++){
//            isPrime[i] = true;
//        }
//
//        for (int i=2; i*i<=n; i++){
//            if (isPrime[i]){
//                for (int j=2*i; j<=n; j+=i){
//                    isPrime[j] = false;
//                }
//            }
//        }
//
//        int m = (int)Math.sqrt(n);
////        for (int i=index; i<=n; i++){
////            if (isPrime[i]){
////                for (int j=index-1; j>0; j--){
////                    if (isPrime[j]){
////                        if (i*j == n){
////                            System.out.println(i);
////                            return;
////                        }
////                    }
////                }
////            }
////        }
////        System.out.println(index);
//
//        /**********想复杂了，直接找最小质因数即可***********/
//        for (int i=2; i<=m+1; i++){
//            if (n % i == 0){
//                if (isPrime[n/i]){
//                    System.out.println(n/i);
//                    return;
//                }
//            }
//        }
//        System.out.println(Math.sqrt(n));

//        for (int i=n/2+1; i>Math.sqrt(n); i--){
//            if (n % i == 0){
//                System.out.println(i);
//                return;
//            }
//        }


        /******************质因数分解的性质**********************/
        /*******唯一分解定理：一个数只能分解成一组质数的乘积******/
        for (int i=2; i<Math.sqrt(n); i++){
            if (n % i == 0){
                System.out.println(n/i);
                return;
            }
        }

    }
}
