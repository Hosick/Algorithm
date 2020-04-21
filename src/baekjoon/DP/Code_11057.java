package baekjoon.DP;

import java.util.Scanner;

public class Code_11057 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int sum = 0;

        int[][] dp = new int[1001][10]; //  dp[길이 수][맨 앞자리 값]
        for (int i = 0; i <= 9; ++i)
            dp[1][i] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j <= 9; ++j) {
                for (int k = j; k <= 9; ++k) {
                    dp[i][j] += dp[i - 1][k] %= 10007;  //  i자리 수의 맨 앞자리가 j라면 -> i-1자리 수 중 맨 앞 자리값이 j~9인 수의 합이다.
                }
            }
        }

        for (int i : dp[n])
            sum += i;

        System.out.print(sum%=10007);
    }
}