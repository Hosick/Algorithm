package baekjoon.DP;

import java.util.Scanner;

public class Code_6359 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean[] dp = new boolean[101];
        for (int i = 1; i <= 100; i++)  //  1라운드에 모든 문을 열어 놓음
            dp[i] = true;

        for (int i = 2; i <= 100; ++i) {    //  2~100 라운드
            for (int j = 1; i * j <= 100; ++j) {     //  라운드의 곱할 수
                dp[i * j] = !dp[i * j];
            }
        }

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int count = 0;

            for (int i = 1; i <= n; ++i) {
                if (dp[i])
                    count++;
            }

            System.out.println(count);
        }
    }
}
