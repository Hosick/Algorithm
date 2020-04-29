package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Code_1010 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] dp = new int[30][30];   //  강서 강동 각각 30의 dp 배열 생성
        for (int i = 1; i < 30; ++i)    //  dp[1][i] = i로 초기화
            dp[1][i] = i;

        for (int i = 2; i < 30; ++i) {
            for (int j = i; j < 30; ++j) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1]; //  dp[i][j] = dp[i-1][i-j] ~ dp[i-1][j-1]의 합이므로
            }
        }

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();

            System.out.println(dp[n][m]);
        }
    }
}