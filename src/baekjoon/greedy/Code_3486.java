package baekjoon.greedy;

import java.util.Scanner;

public class Code_3486 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t-- > 0){
            int a = input.nextInt();
            int b = input.nextInt();

            System.out.println(getRevers(getRevers(a) + getRevers(b)));
        }
    }


    /* 정수를 뒤짚는 함수 */
    static int getRevers(int n) {
        String s = Integer.toString(n);
        String rs = "";
        for (int i = s.length() - 1; i >= 0; --i) {
            rs += s.charAt(i);
        }

        return Integer.parseInt(rs);
    }
}