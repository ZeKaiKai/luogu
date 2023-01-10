package day9;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1498 {
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int length =  4, k = 1;
        char[][] a = new char[1024][2048];

        for (int i = 0; i < 1024; i++) {
            for (int j = 0; j < 2048; j++) {
                a[i][j] = ' ';
            }
        }
        a[0][0] = a[1][1] = '/';
        a[0][1] = a[0][2] = '_';
        a[0][3] = a[1][2] = '\\';

        while(k < n) {
            for (int i = 0; i < length / 2; i++) {
                for (int j = 0; j < length; j++) {
                    a[i+(length/2)][j+(length/2)] = a[i][j+length] = a[i][j];
                }
            }
            length *= 2;
            k++;
        }

        for (int i = (length/2)-1; i >= 0; i--) {
            for (int j = 0; j < length; j++) {
                out.write(a[i][j]);
            }
            out.write('\n');
        }
        out.flush();
        out.close();
    }
}
