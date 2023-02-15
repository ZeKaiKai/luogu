package day24;

import java.util.Arrays;
import java.util.Scanner;

/*****************只拿了60分*********************/
public class lq2022_D_最少刷题数 {
    public static int[] arr;
    public static int[] find;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n];
        find = new int[n];

        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            arr[i] = t;
            find[i] = t;
        }

        Arrays.sort(find);

        int tar = n / 2; //目标刷题数的数组下标
        int less = 0;
        int more = 0;
        // 统计大于中位数和小于中位数的个数
        for (int i = 0; i < n; i++) {
            if (arr[i] > find[tar])
                more++;
            if (arr[i] < find[tar])
                less++;
        }

        int target = find[tar];


        if (n % 2 == 0) {
            if (less > more)
                target = find[tar];
            else if (less < more)
                target = find[tar] + 1;
            else if (less == more)
                target = find[tar] + 1;
        } else {
            if (less > more)
                target = find[tar];
            else if (less < more)
                target = find[tar] + 1;
            else if (less == more)
                target = find[tar] + 1;
        }

        for (int i : arr) {
            if (i >= target) {
                System.out.print(0 + " ");
            } else {
                if (i == find[tar])
                    System.out.print(0 + " ");
                else
                    System.out.print(target - i + " ");
            }
        }
    }

    public static int bSearch(int x) {
        int l = 0, r = find.length;

        while (l < r) {
            int mid = (l + r) >> 1;
            if (find[mid] >= x)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}

/**
 * 满分代码
 * import java.util.Arrays;
 * import java.util.Scanner;
 * <p>
 * public class Main {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * int n = sc.nextInt();
 * int[] a = new int[n], tmp = new int[n];
 * for (int i = 0; i < n; i++) {
 * a[i] = sc.nextInt();
 * tmp[i] = a[i];
 * }
 * Arrays.sort(tmp);
 * int mid = tmp[n / 2];
 * int bg_cnt = 0, sml_cnt = 0; // 记录比mid大的和比mid小的数
 * for (int i = 0; i < n; i++)
 * if (a[i] < mid) sml_cnt ++;
 * else if (a[i] > mid) bg_cnt ++;
 * <p>
 * if (bg_cnt < sml_cnt) {
 * for (int i = 0; i < n; i++)
 * if (a[i] < mid) System.out.print(mid - a[i] + " ");
 * else System.out.print(0 + " ");
 * } else if (bg_cnt == sml_cnt){
 * for (int i = 0; i < n; i++)
 * if (a[i] < mid) System.out.print(mid - a[i] + 1 + " ");
 * else System.out.print(0 + " ");
 * }else {
 * for (int i = 0; i < n; i++)
 * if (a[i] <= mid) System.out.print(mid - a[i] + 1 + " ");
 * else System.out.print(0 + " ");
 * }
 * }
 * }
 **************************/