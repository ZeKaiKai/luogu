package day29;

import java.util.Scanner;

/**
 *数论，砝码重量为3^n
 * 一个砝码 1
 * 两个砝码 1 3
 * 三个砝码 1 3 9
 * 四个砝码 1 3 9 27
 * 别被题目提示误导了...
 */
public class lq2021_G_最少砝码 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int sum = 0, pow3 = 1, cnt = 0;

        do {
            sum += pow3;
            pow3 *= 3;
            cnt++;
        } while (sum < num);

        System.out.println(cnt);

    }
}
