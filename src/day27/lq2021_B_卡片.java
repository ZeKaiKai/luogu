package day27;

import java.io.*;
import java.util.HashMap;

// map和ascii
public class lq2021_B_卡片 {
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            map.put(i, 2021);
//        }
//
//        int i = 1;
//        while (true) {
//            for (char c : String.valueOf(i).toCharArray()) {
//                if (map.get(c-48) != 0) {
//                    map.put(c-48, map.get(c-48)-1); //值-1
//                    continue;
//                } else {
//                    System.out.println(i-1);
//                    return;
//                }
//            }
//            i++;
//        }
        System.out.println(3181);

    }

    public static int nextInt() throws IOException{
        st.nextToken();
        return (int) st.nval;
    }
}
