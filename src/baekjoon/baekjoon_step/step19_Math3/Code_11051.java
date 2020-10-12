package baekjoon.baekjoon_step.step19_Math3;

import java.util.Scanner;

public class Code_11051 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1;

        /*이항 계수 계산 (DP)*/
        for (int i = 1; i <= n; ++i) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            for (int j = 1; j < i; ++j) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]);
                dp[i][j] %= 10007;
            }
        }
        System.out.print(dp[n][k]);
    }
}