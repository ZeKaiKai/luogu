package day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class P5076 {
    static List<Integer> list=new LinkedList<>();
    static int size=2;
    public static void main(String[] args) throws Exception{
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//快速输出
        Read read=new Read();//快读
        int n=read.nextInt();
        list.add(-2147483647);//添加上界与下界
        list.add(2147483647);
        while(n-->0) {
            int op=read.nextInt();
            int num=read.nextInt();
            switch (op) {
                case 1: {
                    out.println(lower(num)+1);//注意，num可能不存在，所以要找到比num小的数中最大的一个的下标，再＋1；
                    break;
                }
                case 2:{
                    out.println(list.get(num));
                    break;
                }
                case 3:{
                    int index=lower(num);
                    out.println(list.get(index));
                    break;
                }
                case 4:{
                    int index=higher(num);//二分答案
                    out.println(list.get(index));
                    break;
                }
                case 5:{
                    int index=higher(num);	//二分答案
                    list.add(index, num);;
                    size++;
                    break;
                }
            }
        }

        out.flush();

    }
    //二分答案：查找小于目标数的最大数的下标， 例如 1 2 4 5 ，target为3，小于target的最大的数为2。
    static int lower(int target) {
        int left=0;
        int right=size-1;
        while(left<right) {
            int mid=(left+right)/2;
            if(list.get(mid)>=target)
                right=mid;
            else {
                left=mid+1;
            }
        }
        return left-1;
    }
    //二分答案，查找大于目标数的的最小的一个。
    static int higher(int target){
        int left=0;
        int right=size-1;
        while(left<right) {
            int mid=(left+right)/2+1;
            if(list.get(mid)<=target) {
                left=mid;
            }
            else {
                right=mid-1;
            }
        }
        return left+1;
    }
}
class Read{
    StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public int nextInt() throws Exception{
        st.nextToken();
        return (int)st.nval;
    }
}