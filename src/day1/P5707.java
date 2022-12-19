package day1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class P5707 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int v = in.nextInt();

        Calendar date = Calendar.getInstance();
        date.set(2022, Calendar.MAY, 5, 8, 0, 0);
        date.add(Calendar.MINUTE, -10);
        date.add(Calendar.MINUTE, s%v==0 ? -(s/v) : -(s/v)-1); //不是整数分钟的话多减一分钟
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        System.out.println(format.format(date.getTime()));
    }
}
