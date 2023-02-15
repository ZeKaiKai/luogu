package day24;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class lq2022_C_字符统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            // 记录每个字母个数
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
            // 记录最大值
            if (map.get(c) > count) {
                count = map.get(c);
            }
        }

        // TreeSet可以维护字典序
        TreeSet<Character> set = new TreeSet<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            // 个数等于最大值就加入TreeSet中
            if (entry.getValue()==count) {
                set.add(entry.getKey());
            }
        }

        // 遍历输出
        for (Character c : set) {
            System.out.print(c);
        }
    }
}
