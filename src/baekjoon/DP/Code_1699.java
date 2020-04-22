package baekjoon.DP;

import java.util.Scanner;

public class Code_1699 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        int quo = 2;
        for (int i = 2; i <= n; ++i) {
            if (quo * quo == i) {   //  다음 단일 제곱수 찾기
                dp[i] = 1;
                quo++;
                continue;
            }
            dp[i] = dp[i - 1] + 1;  //  우선 dp[i - 1] + 1^2  으로 초기화
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[j * j] + dp[i - (j * j)]);   //  dp[j의 제곱수] + dp[i - j의 제곱수]와 min 연산
            }
        }
        System.out.print(dp[n]);
    }
}
