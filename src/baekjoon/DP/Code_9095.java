package baekjoon.DP;

import java.util.Scanner;

public class Code_9095 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < 11;++i)
            dp[i] = dp[i-1] + dp[i-2] + dp[i -3];

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            System.out.println(dp[n]);
        }
    }
}
