package day28;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class lq2021_F_时间显示 {
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            long day = in.nextLong();

            long seconds = day % 60000;
            day -= seconds;
            seconds /= 1000;

            long minutes = day % 3600000;
            day -= minutes;
            minutes /= 60000;  //minutes

            long hours = day % (24 * 60 * 60 * 1000);
            hours /= (60 * 60 * 1000);//hours

            String h = String.valueOf(hours);
            if (hours < 10) {
                h = '0' + String.valueOf(hours);
            }

            String m = String.valueOf(minutes);
            if (minutes < 10) {
                m = '0' + String.valueOf(minutes);
            }

            String s = String.valueOf(seconds);
            if (seconds < 10) {
                s = '0' + String.valueOf(seconds);
            }

            out.println(h + ":" + m + ":" + s);
        }
        out.flush();
    }
}
