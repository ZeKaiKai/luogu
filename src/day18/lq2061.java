package day18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class lq2061 {
    public static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    public static int[][] mat;
    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int M = nextInt();
        mat = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mat[i][j] = nextInt();
            }
        }

        int Limit = nextInt();


    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
