package day31_模拟比赛;

public class lq2019_3_数列求值 {
    public static void main(String[] args) {
        int n = 20190324;
        int x1 = 1;
        int x2 = 1;
        int x3 = 1;
        int cur = 0;
        int index = 4;

        while(true) {
            cur = (x1 + x2 + x3) % 10000;
            x1 = x2;
            x2 = x3;
            x3 = cur;
            // cur的index，第一次循环是4
            if (index == 20190324)
                break;

            index++;
        }

        System.out.println(cur);

        System.out.println(4659);
    }
}
