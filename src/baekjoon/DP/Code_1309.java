package baekjoon.DP;

import java.util.Scanner;

public class Code_1309 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[][] dp = new int[n + 1][3];
        dp[1][0] = 1;   //  1행에 사자가 없을 경우의 수를 1로 초기화
        dp[1][1] = 1;   //  1행 1열에 사자가 있는 경우의 수를 1로 초기화
        dp[1][2] = 1;   //  1행 2열에 사자가 있는 경우의 수를 1로 초기화

        for (int i = 2; i <= n; ++i) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        System.out.print((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
    }
}
