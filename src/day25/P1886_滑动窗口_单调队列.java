package day25;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;



/**************
 *  pop是弹栈，poll是出队
 *  pop底层调用removeFirst，poll底层调用pollFirst
 *  队列为空时pop抛出NoSuchElement异常，poll返回null
 * **************/

public class P1886_滑动窗口_单调队列 {
    static class node {
        int order;
        int value;
    }
    public static LinkedList<node> max = new LinkedList<>();
    public static LinkedList<node> min = new LinkedList<>();
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int k = nextInt();

        int[] a_min = new int[n];
        int[] a_max = new int[n];
        int t = 0;
        int m_lo = 0;

        for (int i = 0; i < n; i++) {
            t = nextInt();
            if (!max.isEmpty() && i-max.peekFirst().order >= k) max.pollFirst();
            if (!min.isEmpty() && i-min.peekFirst().order >= k) min.pollFirst();
            while (!max.isEmpty() && max.peekLast().value < t) max.pollLast();
            while (!min.isEmpty() && min.peekLast().value > t) min.pollLast();

            node temp = new node();
            temp.value = t;
            temp.order = i;
            max.add(temp);
            min.add(temp);

            if (i >= k-1) {
                a_max[m_lo] = max.peekFirst().value;
                a_min[m_lo] = min.peekFirst().value;
                m_lo++;
            }
        }

        for (int i = 0; i < m_lo; i++) {
            if (i==m_lo-1) out.println(a_min[i]);
            else out.print(a_min[i] + " ");
        }
        for (int i = 0; i < m_lo; i++) {
            if (i==m_lo-1) out.println(a_max[i]);
            else out.print(a_max[i] + " ");
        }
        out.flush();
    }

    // 快读
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
