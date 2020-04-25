package baekjoon.DP;

import java.util.Scanner;

public class Code_2225 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  합으로 만들 정수
        int k = input.nextInt();    //  n으로 만들 정수의 개수

        long[][] dp = new long[n+1][k+1];   //  자료형이 long 인 2차원 dp 배열
        for (int i = 0; i <= n; ++i){       //  dp[i][1]을 모두 1로 초기화
            dp[i][1] = 1;                   //  (한자리로는 i 자신으로만 i를 만들 수 있기 때문)
        }

        for(int i = 2; i <= k; ++i){
            for(int j = 0; j <= n; ++j){
                for (int l = 0; l<=j; ++l){
                    dp[j][i] += dp[l][i-1]  %   1000000000; //  dp[n][k]는 dp[0][k-1] ~ dp[n][k-1]의 합이다
                }
            }
        }

        System.out.print(dp[n][k]   %   1000000000);
    }
}