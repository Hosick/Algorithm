package baekjoon.DP;

import java.util.Scanner;

public class Code_11727 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; ++i){
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        System.out.print(dp[n]);
    }
}
