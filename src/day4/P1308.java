package day4;

import java.util.Locale;
import java.util.Scanner;

public class P1308 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String key = in.nextLine().toLowerCase();
        String str = in.nextLine().toLowerCase();

        String[] words = str.split(" ");

        int count = 0;
        for (String word : words) {
            if (word.equals(key)){
                count++;
            }
        }

        if (count == 0){
            System.out.println(-1);
            return;
        }

        // 两种特判

        // 第一次匹配在首部
        if (str.indexOf(key+" ") == 0){
            System.out.print(count);
            System.out.print(" ");
            System.out.print(0);
            return;
        }

        // 中间情况
        int index = str.indexOf(" "+key+" ");
        if (index >= 0){
            System.out.print(count);
            System.out.print(" ");
            System.out.println(index+1);
            return;
        }

        // 第一次匹配在尾部
        // 匹配坐标等于字符串长度 - 最后一个单词的长度
        int lastLength = words[words.length-1].length();
        int strlen = str.length();
        index = str.indexOf(" "+key);
        if (index == strlen - lastLength - 1){
            System.out.print(count);
            System.out.print(" ");
            System.out.println(index+1);
            return;
        }

    }
}
