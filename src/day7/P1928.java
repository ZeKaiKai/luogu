package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 网上找到的代码
 * 用栈模拟递归
 * 多位数字的处理：
 *      1、单位数字，判断条件为栈顶是[，即前一位是[，直接入栈
 *      2、多位数字，判断条件是栈顶是否是数字，即前一位是数字，是的话与前一位拼接后入栈
 */
public class P1928{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char c[] = reader.readLine().trim().toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < c.length; i++) { // 如果栈为空
            if (stack.isEmpty()) {
                // 如果是[,直接进栈
                if (c[i] == '[') {
                    stack.add("[");
                } else {// 否则直接加入结果串
                    sb.append(c[i]);
                }

            } else { // 栈不为空
                // 如果是[,直接进栈
                if (c[i] == '[') {
                    stack.add("[");
                } else {
                    if (c[i] >= '0' && c[i] <= '9') {
                        // 如果是数字有两种情况；
                        if (stack.peek().equals("[")) {
                            // 如果是一位数(前面就是[)
                            stack.add(c[i] + "");
                        } else {
                            // 如果是两位数(前面不是[)
                            // 拼接后加入栈中
                            String str = stack.peek();
                            stack.pop();
                            stack.add((str + c[i]));
                        }
                    } else {
                        // 如果是字母
                        if (c[i] >= 'A' && c[i] <= 'Z') {
                            char temp = stack.peek().charAt(0);
                            if (temp >= '0' && temp <= '9') {
                                // 如果前面是数字直接加入栈
                                stack.add(c[i] + "");
                            }else {
                                String str = stack.peek();
                                stack.pop();
                                stack.add((str + c[i]));
                            }
                        }else
                        {
                            //只剩下一种情况']'
                            //取出字符串
                            String str=stack.pop();;

                            //取出数字
                            int number=Integer.parseInt(stack.pop());

                            //弹出'['
                            stack.pop();
                            String temp="";
                            for(int j=0;j<number;j++)
                                temp+=str;
                            if(stack.isEmpty())
                            {
                                //如果栈为空直接加入sb
                                sb.append(temp);
                            }else
                            {
                                //如果栈不为空，分两种情况
                                //一种情况，前面是数字，直接加入temp
                                char tc = stack.peek().charAt(0);
                                if (tc >= '0' && tc <= '9') {
                                    // 如果前面是数字直接加入栈
                                    stack.add(temp);
                                }else {
                                    String s = stack.peek();
                                    stack.pop();
                                    stack.add(s+temp);
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
