package day30;

public class Dijkstra {
    public static int[] dijkstra(int[][] graph, int startVertex) {
        int length = graph.length;
        int[] result = new int[length];

        int[] notFound = new int[length];
        //初始化
        for (int i = 0; i < length; i++) {
            result[i] = -1;
        }
        result[startVertex] = 0;
        for (int i = 0; i < length; i++) {
            notFound[i] = graph[startVertex][i];
        }
        notFound[startVertex] = -1;

        //开始算法
        for (int i = 0; i < length; i++) {
            if (i == startVertex)
                continue;
            //找到当前notFound中的最小值
            int minIndex = 0, min = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                if (notFound[j]>0 && notFound[j] < min) {
                    min = notFound[j];
                    minIndex = j;
                }
            }
            //将最小值取出并放入结果集合
            notFound[minIndex] = -1;
            result[minIndex] = min;

            //更新notFound值
            //遍历当前最小值的出度
            for (int j = 0; j < length; j++) {
                //出度可通行，且不在结果集合中
                if (graph[minIndex][j]>0 && result[j]==-1){
                    //
                    int newDistance = graph[minIndex][j] + result[minIndex];
                    //当前值更小，或原本不可通行
                    if (newDistance < notFound[j] || notFound[j]==-1) {
                        notFound[j] = newDistance;
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        char[] vertices = new char[]{'A', 'B', 'C', 'D'};
        int[][] graph = new int[][]{
                {0, 2, -1, 6},
                {2, 0, 3, 2},
                {-1, 3, 0, 2},
                {6, 2, 2, 0}};
        int[] dis = dijkstra(graph, 0);
        for (int di : dis) {
            System.out.println(di);
        }
    }
}
