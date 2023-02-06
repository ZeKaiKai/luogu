package day18;

public class lq2057 {
    public static void main(String[] args) {
        int cnt = 0;

        for (int i = 2022; i <= 2022222022; i++) {
            if (isTrue(i)) {
//                System.out.println(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
    public static Boolean isTrue(int x) {
        String s = String.valueOf(x);
        int l = s.length();
        int bound = l%2==0 ? l/2 : (l+1)/2; // 因为位数为奇数时，需要判断中间的一位
        char[] c = s.toCharArray();

        for (int j = 0; j < bound; j++) {
            if (c[j] != c[l - j - 1])
                return false;
            if (j >= 1 && c[j] - c[j - 1] < 0)
                return false;
        }
        return true;
    }
}