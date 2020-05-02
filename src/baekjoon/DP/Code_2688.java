package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Code_2688 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long[][] dp = new long[65][10]; //  dp[자리 수][가장 앞 자리]
        Arrays.fill(dp[1], 1);     //   한 자리수 dp 배열 1로 초기화

        for (int i = 2; i <= 64; ++i) { //  dp[i][j]는 dp[i-1][j]~dp[i-1][9]의 합
            for (int j = 0; j <= 9; ++j) {
                for (int k = j; k <= 9; ++k) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        int t = input.nextInt();
        while (t-- > 0){
            int n  = input.nextInt();

            long sum = 0;
            for (int i = 0; i <=9; ++i)
                sum += dp[n][i];

            System.out.println(sum);
        }
    }
}
