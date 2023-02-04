package day16;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1827 {
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String mid = in.nextLine();
        String pre = in.nextLine();

        solve(mid.trim(), pre.trim());
        out.flush();
    }

    private static void solve(String mid, String pre) throws IOException {
        if (pre.length() == 0)
            return;

        int i = mid.indexOf(pre.charAt(0));

        String pre_left = pre.substring(1, i+1);
        String pre_right = pre.substring(i+1);

        String mid_left = mid.substring(0, i);
        String mid_right = mid.substring(i+1);

        solve(mid_left, pre_left);
        solve(mid_right, pre_right);

        out.write(pre.charAt(0));
    }
}
