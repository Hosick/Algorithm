package baekjoon.baekjoon_step.step16_DP1;

import java.util.Scanner;

public class Code_12865 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  물건 갯수
        int k = input.nextInt();    //  최대 무게

        int[] weight = new int[n+1];  //  물건의 무게
        int[] value = new int[n+1];   //  물건의 가치
        int[][] dp = new int[n + 1][k + 1]; //  dp 2차원 배열

        for (int i = 1; i <= n; ++i) {
            weight[i] = input.nextInt();
            value[i] = input.nextInt();
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i - 1][j];    //  (이전 물건, 무게 j) 가치로 초기화
                if (j - weight[i] >= 0) {   //  남는 무게가 있다면
                    dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - weight[i]] + value[i]); // 남는 무게의 최대값으로 채워서 더한 값이 더 크다면 초기화
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}