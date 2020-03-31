package baekjoon.DP;

import java.util.Scanner;

public class Code_11052 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] card = new int[n+1];
        for(int i = 1; i <= n; ++i)
            card[i] = input.nextInt();

        /* dp */
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = card[1];
        for (int  i = 2; i <= n; ++i){
            dp[i] = card[i];    //  일단 카드[i] 로 초기화
            for(int j = 1; j <= i/2; ++j){
                dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);   //  dp[j] + dp[i-j]가 더 크다면 교체
            }
        }

        System.out.print(dp[n]);
    }
}
