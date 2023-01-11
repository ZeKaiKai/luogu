package day10;

import java.util.Scanner;

public class P1106 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = in.nextInt();
        char[] a = s.toCharArray();

        int l = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                if (j == l - 1) {
                    l--;
                    break;
                }
                if (a[j] > a[j + 1]) {
                    // 移除这一位
                    for (int k = j; k < l - 1; k++) {
                        a[k] = a[k + 1];
                    }
                    // 长度减一
                    l--;
                    break;
                }
            }
        }

        // 去除前缀0
        int i = 0;
        while(a[i]=='0'){
            // 考虑输出全为0的情况
            if (i == l-1) {
                System.out.println(0);
                return;
            }
            i++;
        }
        // 考虑处理后剩余长度为0的情况
        if (l == 0){
            System.out.println(0);
            return;
        }
        // 从第一个不是0的数字开始输出
        for (; i < l; i++) {
            System.out.print(a[i]);
        }
    }
}
