package baekjoon.baekjoon_step.step30_DP3;

import java.util.Scanner;

public class Code_17404 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    //  집의 개수

        /* 집 별 페인트 색상의 사용 비용 배열 선언 및 입력 */
        int[][] paint = new int[n + 1][3];  //  [i번집][페인트 색상] = 비용
        for (int i = 1; i <= n; ++i) {
            paint[i][0] = input.nextInt();
            paint[i][1] = input.nextInt();
            paint[i][2] = input.nextInt();
        }

        /* DP 배열 선언 및 계산 */
        int ans = 1000001;
        int[][] dp = new int[n + 1][3]; //  [집 번호][페인트 색상] = 총합의 최소값
        for (int i = 0; i < 3; ++i) {    //  색을 하나씩 정해서 처음 집을 해당색으로 고정
            for (int j = 0; j < 3; ++j) {   //  해당 색이 아니라면 최대값을 넣어둠
                dp[1][j] = (i == j) ? paint[1][j] : 1000001;
            }

            for (int j = 2; j <= n; ++j) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + paint[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + paint[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + paint[j][2];
            }

            for (int j = 0; j < 3; ++j) {
                if (i == j) continue;       //  처음과 끝집이 같은색이라면 패스
                ans = Math.min(ans, dp[n][j]);
            }
        }
        System.out.println(ans);
    }
}