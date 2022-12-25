package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 自己实现一遍
 */
public class P1928__ {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = reader.readLine().trim().toCharArray();
        StringBuffer buffer = new StringBuffer();

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            // [前面的串无需递归求解，即不用入栈，直接加入结果串即可
            // 前提是它本身不是递归产生的）
            if (stack.isEmpty()) {
                if (chars[i] == '[') {
                    stack.add("[");
                } else {
                    buffer.append(chars[i]);
                }
            } else {
                if (chars[i] == '[') {
                    stack.add("[");
                } else if (chars[i] >= '0' && chars[i] <= '9') {
                    if (stack.peek() == "[") {
                        // 说明是单个数字，直接入栈
                        stack.add(String.valueOf(chars[i]));
                    } else {
                        // 说明不是单个数字，拼接后入栈
                        String n = stack.pop();
                        StringBuffer t = new StringBuffer();
                        t.append(n);
                        t.append(chars[i]);
                        stack.add(t.toString());
                    }
                } else if (chars[i] >= 'A' && chars[i] <= 'Z'){
                    // 字母处理
                    char c = stack.peek().charAt(0);
                    if (c >= '0' && c <= '9') {
                        // 前面是数字，说明是第一个字母
                        stack.add(String.valueOf(chars[i]));
                    } else if (c >= 'A' && c <= 'Z') {
                        // 否则不是第一个字母，则与前面的字母拼接，入栈
                        String pop = stack.pop();
                        StringBuffer temp = new StringBuffer();
                        temp.append(pop);
                        temp.append(chars[i]);
                        stack.add(temp.toString());
                    }
                }else if (chars[i] == ']') {
                    // 如果是]，先pop前两个元素，拼接出结果，再判断栈是否为空
                    String pop = stack.pop();
                    Integer n = Integer.valueOf(stack.pop());
                    String pop1 = stack.pop();

                    // 获取中间结果串
                    StringBuffer temp = new StringBuffer();
                    for (int j = 0; j < n; j++) {
                        temp.append(pop);
                    }

                    // 如果栈空，则直接加入结果串
                    if (stack.isEmpty()) {
                        buffer.append(temp);
                    } else {
                        // 如果栈非空，可能要继续递归调用，而前面可能还有数字 或 字母
                        char c = stack.peek().charAt(0);
                        if (c >= '0' && c <= '9') {
                            // 如果是数字，直接入栈
                            stack.add(temp.toString());
                        } else {
                            //如果是字母，拼接后入栈
                            StringBuffer t = new StringBuffer(stack.pop());
                            t.append(temp);
                            stack.add(t.toString());
                        }
                        // 推导易知不可能是[
                    }

                }
            }
        }
        System.out.println(buffer);
    }
}
