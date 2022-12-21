package day3;

import java.util.Scanner;

public class P1055 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        String[] split = s.split("-");
//        int[] arr = new int[split.length];
//
//
//        for (int i = 0; i < split.length; i++) {
//            if (split[i].equals("X")) {
//                arr[i] = 10;
//            } else {
//                arr[i] = Integer.valueOf(split[i]);
//            }
//        }
//
//        int[] ints = new int[9];
//
//        ints[0] = arr[0];
//
//        ints[3] = arr[1] % 10;
//        arr[1] /= 10;
//        ints[2] = arr[1] % 10;
//        arr[1] /= 10;
//        ints[1] = arr[1] % 10;
//
//        ints[8] = arr[2] % 10;
//        arr[2] /= 10;
//        ints[7] = arr[2] % 10;
//        arr[2] /= 10;
//        ints[6] = arr[2] % 10;
//        arr[2] /= 10;
//        ints[5] = arr[2] % 10;
//        arr[2] /= 10;
//        ints[4] = arr[2] % 10;
//
//        int res = 0;
//        for (int i = 0; i < 9; i++) {
//            res += ints[i] * (i + 1);
//        }
//
////        String result = null;
////        if (res % 11 == 10) {
////            result = "X";
////        } else {
////            result = String.valueOf(res % 11);
////        }
////
////        if (result.equals(String.valueOf(arr[3]))) {
////            System.out.println("Right");
////        } else {
////            for (int i = 0; i < split.length - 1; i++) {
////                System.out.print(split[i]);
////                System.out.print("-");
////            }
////            System.out.print(result);
////        }
//        res = res % 11;
//        if ((res == 10 && split[3].equals("X")) || res == Integer.valueOf(split[3])){
//            System.out.println("Right");
//        } else{
//            System.out.print(split[0]);
//            System.out.print("-");
//            System.out.print(split[1]);
//            System.out.print("-");
//            System.out.print(split[2]);
//            System.out.print("-");
//            System.out.print(String.valueOf(res));
//        }

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int sum = 0;
        sum = (s.charAt(0) - '0') * 1 + (s.charAt(2) - '0') * 2 + (s.charAt(3) - '0') * 3 + (s.charAt(4) - '0') * 4 +
                (s.charAt(6) - '0') * 5 + (s.charAt(7) - '0') * 6 + (s.charAt(8) - '0') * 7 + (s.charAt(9) - '0') * 8 + (s.charAt(10) - '0') * 9;

        char c = sum % 11 < 10 ? (char) (sum % 11 + '0') : 'X';
        if (c == s.charAt(12)) {
            System.out.println("Right");
        } else {
            System.out.println(s.substring(0,12) + c);
        }

    }
}
