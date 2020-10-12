package baekjoon.baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_2565 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int answer = 0;
        int[] line = new int[501];
        int[] dp = new int[501];

        /* 줄 입력 */
        for (int i = 0; i < n; ++i)
            line[input.nextInt()] = input.nextInt();

        for (int i = 1; i <= 500; ++i) {
            if (line[i] != 0) dp[i] = 1;
            /* LIS로 풀기*/
            for (int j = 1; j < i; ++j) {
                if (line[j] != 0 && line[j] < line[i] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(n - answer);
    }
}
