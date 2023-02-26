package day30;

public class Floyd {
    static int[][] graph = new int[2050][2050];
    static final int INF = 0x3f3f3f3f;

    private static void floyd() {
        for (int k = 1; k <= 2021; k++) {
            for (int i = 1; i <= 2021; i++) {
                for (int j = 1; j <= 2021; j++) {
                    if (i != j && graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
//        for (int i = 1; i <= 2021; i++) {
//            for (int j = 1; j <= 2021; j++) {
//                graph[i][j] = INF;
//            }
//        }
//
//        for (int i = 1; i <= 2021; i++) {
//            int st = Math.max(i - 21, 1);
//            for (int j = st; j <= i; j++) {
//                int div = gcd(j, i);
//                int lcm = i * j / div;
//                graph[i][j] = lcm;
//                graph[j][i] = lcm;
//            }
//        }
//
//        floyd();
//
//        System.out.println(graph[1][2021]);

        System.out.println(10266837);
    }
}
