package baekjoon.DP;

import java.util.Scanner;

public class Code_2482 {
    static int n;
    static int k;
    static int[][] dp;
    static final int MOD = 1000000003;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();        //  색의 개수
        int k = input.nextInt();        //  고를 색의 개수
        dp = new int[n + 1][n + 1];    //  dp 배열 선언 : [i개의 색 중][j개 선택]의 경우의 수

        for (int i = 1; i <= n; ++i) {
            dp[i][1] = i;   //  i개의 색 중 1개를 선택하는 경우는 i개
            dp[i][0] = 1;   //  i개의 색 중 선택안하는 경우는 1가지
        }

        for (int i = 3; i <= n; ++i) {                  //  i개의 색 중
            for (int j = 2; j <= (i + 1) / 2; ++j) {    //  j개를 선택
                /* i번째 색을 선택했을 때와 선택하지 않았을 때로 나누어서 생각할 수 있다 */
                /* i번째 색을 선택했다면 i - 2까지 j - 1개 선택이 가능하므로 dp[n - 2][j - 1] */
                /* i번재 색을 선택하지 않았다면 i - 1까지 j개 선택이 가능하므로 dp[n - 1][j] */
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        /* 정답 또한 (n번째 색 선택) + (n번째 색 미선택) */
        /* n번을 선택했을 때 1번을 선택이 불가능하기 때문에 [n-3] */
        int answer = (dp[n - 3][k - 1] + dp[n - 1][k]) % MOD;
        System.out.println(answer);
    }
}