package baekjoon.DP;

import java.util.Scanner;

public class Code_1562 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  자리 수
        long sum = 0;                //  합계
        final int MOD = 1000000000; //  합계를 나눌 몫
        int visit = 1 << 10;    // 0 ~ 9 비트마스킹 최대값 + 1
        int bit;

        long[][][] dp = new long[101][10][visit];
        for (int i = 1; i < 10; i++)    //  1자리수이고 i로 끝나는 수 비트마스킹 채우기
            dp[1][i][1 << i] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j <= 9; ++j) {
                for (int k = 0; k < visit; ++k) {
                    bit = k | (1 << j);   //  기존 비트마스킹 + 끝나는 수 j의 비트마스킹 합
                    /*  비트마스킹 별 n자리 수의 개수 구하기 */
                    dp[i][j][bit] = (dp[i][j][bit] +
                            ((0 < j ? dp[i - 1][j - 1][k] : 0) +
                                    (j < 9 ? dp[i - 1][j + 1][k] : 0)) % MOD
                    ) % MOD;
                }
            }
        }

        /* 자리수가 n이고 비트마스킹이 꽉 채워져있는 값들의 합 구하고 출력 */
        for (int i = 0; i <= 9; ++i)
            sum = (sum + dp[n][i][visit-1])%MOD;
        System.out.println(sum);
    }
}