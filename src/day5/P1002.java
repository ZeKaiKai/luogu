package day5;

import java.util.Scanner;

public class P1002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        Long[][] a = new Long[n + 1][m + 1];

        a[x][y] = 0L;

        boolean[][] visited = new boolean[n + 1][m + 1];
        int[][] moves = {{-1, 2}, {1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, 1}, {2, -1}};

        // 马一步跳到的点置true
        visited[x][y] = true;
        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];
            if (newX >= 0 && newX <= n && newY >= 0 && newY <= m) {
                visited[newX][newY] = true;
            }
        }
        for (int i = 0; i < n+1; i++) {
            a[i][0] = 1L;
        }
        for (int i = 0; i < m+1; i++) {
            a[0][i] = 1L;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (visited[i][j]) {
                    a[i][j] = 0L;
                } else {
                    a[i][j] = a[i - 1][j] + a[i][j - 1];
                }
            }
        }

        System.out.println(a[n][m]);
    }
}
