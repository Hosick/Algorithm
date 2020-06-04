/**
 * 이 문제는 DP를 이용하여 푸는 것이 가장 간단하다.
 * 빌딩을 n-1개 세운 상황에서 가장 작은 빌딩을 추가한다고 생각했을 때
 * [i-1][j-1][k] 에서 가장 왼쪽에 세우면 [i][j][k]가 되고
 * [i-1][j][k-1] 에서 가장 오른쪽에 세워도 [i][j][k]가 된다.
 * 나머지 자리에는 아무곳에나 세우던 값이 그대로기 때문에 [i-1][j][k] * (n - 2)를 더해주면 된다.
**/
package baekjoon.DP;

import java.util.Scanner;

public class Code_1328 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  빌딩의 개수
        int l = input.nextInt();    //  가장 왼쪽에서 봤을 때 보이는 빌딩의 개수
        int r = input.nextInt();    //  가장 오른쪽에서 봤을 때 보이는 빌딩의 개수

        long[][][] dp = new long[101][101][101];
        dp[1][1][1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= l; ++j) {
                for (int k = 1; k <= r; ++k) {
                    dp[i][j][k] = dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] + dp[i - 1][j][k] * (i - 2);
                    dp[i][j][k] %= 1000000007;
                }
            }
        }

        System.out.println(dp[n][l][r] % 1000000007);
    }
}