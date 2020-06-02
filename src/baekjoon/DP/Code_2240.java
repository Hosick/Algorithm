package baekjoon.DP;

import java.util.Scanner;

public class Code_2240 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();        //  자두가 떨어지는 총 시간
        int w = input.nextInt();        //  자두의 최대 이동 횟수

        int[][] dp = new int[t + 1][t + 1];   //  dp 배열 [몇번째 자두인지] [몇번 이동했는지]

        int tree;   //  몇번째 나무에서 떨어지는지
        for (int i = 1; i <= t; ++i) {                  //  현재 시간 (사과의 순서)
            tree = input.nextInt();
            if (tree == 1)                              //  아예 이동안했다면 1번일 경우에만 증가
                dp[i][0] = dp[i - 1][0] + 1;
            for (int j = 1; j <= i; ++j) {              //  이동 횟수
                /* 첫번째 나무에서 자두가 떨어질 때 */
                if (tree == 1) {
                    /* 나무 아래 있다면 */
                    if (j % 2 == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;    //  나무에 서있던 경우와 이동해서 온 경우 비교
                    }
                    /* 나무 아래 없다면 */
                    else {
                        dp[i][j] = dp[i - 1][j];                                    //  자두를 안받고 넘긴경우
                    }
                }
                /* 두번째 나무에서 자두가 떨어질 때 */
                else {
                    /* 나무 아래 있다면 */
                    if (j % 2 == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;    //  나무에 서있던 경우와 이동해서 온 경우 비교
                    }
                    /* 나무 아래 없다면 */
                    else {
                        dp[i][j] = dp[i - 1][j];                                    //  자두를 안받고 넘긴경우
                    }
                }
            }
        }

        /* 이동횟수 w번 이하일 때 자두를 가장많이먹는 경우의 자두 개수 */
        int max = 0;
        for (int i = 0; i <= w; ++i)
            max = Math.max(max, dp[t][i]);
        System.out.println(max);
    }
}