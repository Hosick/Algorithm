package baekjoon.DP;

import java.util.Scanner;

public class Code_2133 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 0;
        if (n > 1)
            dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {           // 4~n 짝수만
            dp[i] = 3 * dp[i - 2];                  // i-2번째 dp값 * 3
            for (int j = 0; j <= i - 4; j += 2) {    // j= 0부터 i-4까지
                dp[i] += dp[j] * 2;                 // dp[j] * 2 한 값에 계속해서 더해준다.
            }
        }

        System.out.print(dp[n]);
    }
}