package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 尝试用递归实现
 *
 * 勉强90分，剩下一个点MLE
 */
public class P1928___ {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println(dfs());
    }

    public static String dfs() throws IOException {
        // 结果串
        StringBuffer sb = new StringBuffer();

        while (true){
            int read = reader.read();
            char c = (char) read;
            if (c == '\n'){
                break;
            }
            if (c == '[') {
                // 递归求解中括号中的内容，并拼接入结果串
                sb.append(dfs());
            } else if (c >= '0' && c <= '9') {
                StringBuffer b1 = new StringBuffer(""); // 存储可能存在的多个数字
                StringBuffer b2 = new StringBuffer(""); // 存储可能存在的多个字符
                b1.append(c);
                // 处理类似3FUN的符号
                while (true) {
                    char c1 = (char) reader.read(); //存储当前读入的字符
                    if (c1 >= '0' && c1 <= '9') {
                        // 如果不是单个数字，需要与之前的数字拼接
                        b1.append(c1);
                    } else if (c1 >='A' && c1 <='Z') {
                        // 如果是字母，则存储起来
                        b2.append(c1);
                    } else if (c1 == '['){
                        // 继续递归调用，获得的结果串，可能还会被继续计算
                        b2.append(dfs());
                    } else if (c1 == ']') {
                        // ] 说明本次递归结束，计算结果，直接返回
                        int n = Integer.valueOf(b1.toString());
                        for (int i = 0; i < n; i++) {
                            sb.append(b2);
                        }
                        return sb.toString();
                    }
                }
            } else if (c >= 'A' && c <= 'Z') {
                // 是字母，直接拼接入结果串
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
